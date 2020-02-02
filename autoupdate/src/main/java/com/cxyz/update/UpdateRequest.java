package com.cxyz.update;

import android.os.Handler;
import android.os.Looper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

public class UpdateRequest implements Runnable {

    private String downloadUrl;

    private String localFilePath;

    private UpdateDownloadListener listener;

    private boolean isDownloading;

    private long contentLength;

    private DownloadResponseHandler downloadResponseHandler;

    public UpdateRequest(String downloadUrl, String localFilePath, UpdateDownloadListener listener) {
        this.downloadUrl = downloadUrl;
        this.localFilePath = localFilePath;
        this.listener = listener;
        downloadResponseHandler = new DownloadResponseHandler();
    }

    private void makeRequest() throws IOException,InterruptedException {
        try {
            if (!Thread.currentThread().isInterrupted()) {
                HttpURLConnection urlConnection = (HttpURLConnection) new URL(downloadUrl).openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.setConnectTimeout(5000);
                urlConnection.setRequestProperty("Connection","Keep-Alive");
                urlConnection.connect();
                contentLength = urlConnection.getContentLength();
                if (!Thread.currentThread().isInterrupted()) {
                    InputStream inputStream = urlConnection.getInputStream();
                    downloadResponseHandler.sendResponseMessage(inputStream);
                }
            }
        }catch (IOException e) {
            throw e;
        }
    }

    @Override
    public void run() {
        try {
            makeRequest();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    enum Msg {
        IO
    }

    class DownloadResponseHandler {

        private Handler handler = new Handler(Looper.getMainLooper());

        public void sendProgressChangedMessage(int progress) {
            if (listener == null)
                return;
            handler.post(() -> {
                listener.onProgressChanged(progress,downloadUrl);
            });
        }

        public void sendFinishMessage () {
            if (listener == null)
                return;
            handler.post(() -> {
               listener.onFinished(contentLength,downloadUrl);
            });
        }

        public void sendFailMessage (Msg msg) {
            if (listener == null)
                return;
            listener.onFailure("下载异常");
        }

        public void sendResponseMessage(InputStream inputStream) {
            RandomAccessFile randomAccessFile = null;
            try {
                randomAccessFile = new RandomAccessFile(localFilePath,"rwd");
                byte[] bytes = new byte[1024];
                int length = 0;
                int progress = 0;
                int limit = 0;
                long completeSize = 0;
                while ((length = inputStream.read(bytes)) != -1){
                    randomAccessFile.write(bytes,0,length);
                    completeSize += length;
                    progress = (int) (completeSize / contentLength);
                    // 为了不疯狂更新notification，30次更新一下
                    if(limit/30 == 0 && progress <= 100) {
                        sendProgressChangedMessage(progress);
                    }
                    limit ++;
                }
                sendFinishMessage();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                sendFailMessage(Msg.IO);
            } catch (IOException e) {
                e.printStackTrace();
                sendFailMessage(Msg.IO);
            } finally {
                try {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    sendFailMessage(Msg.IO);
                }
            }
        }
    }
}
