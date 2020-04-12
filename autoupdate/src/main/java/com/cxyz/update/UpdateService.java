package com.cxyz.update;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import java.io.File;

public class UpdateService extends Service {
    public static  final int REQUEST_INSTALL = 0;
    /**
     * 下载的apk路径
     */
    private String apkUrl;
    /**
     * 文件路径
     */
    private String filePath;
    /**
     * 下载的大图标
     */
    private int icon;
    /**
     * 下载的小图标
     */
    private int smallIcon;
    /**
     * App的名字
     */
    private String appName;
    private NotificationManager notificationManager;
    private Notification notification;



    @Override
    public void onCreate() {
        Log.e("tag", "UpdateService onCreate()");
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        filePath = Environment.getExternalStorageDirectory() + "/" + BuildConfig.APPLICATION_ID.replace(".","") + "/AppUpdate/base.apk";
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("tag", "UpdateService onStartCommand()");
        if(intent==null){
            notifyUser(getString(R.string.autoupdate_Update_download_failed), getString(R.string.autoupdate_Update_download_failed), 0);
            stopSelf();
        }
        getIntentParams(intent);
        notifyUser(getString(R.string.autoupdate_update_download_start), getString(R.string.autoupdate_update_download_start), 0);
        startDownload();
        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * 从intent中获取参数
     * @param intent
     */
    private void getIntentParams(Intent intent) {
        // 获取下载路径
        apkUrl = intent.getStringExtra("apkUrl");
        // 尝试获取下载文件放置路径
        String path = intent.getStringExtra("filePath");
        if (path != null) {
            filePath = Environment.getExternalStorageDirectory() + path;
        }
        // 获取图标
        icon = intent.getIntExtra("icon",R.mipmap.logo);
        smallIcon = intent.getIntExtra("smallIcon",R.mipmap.logo);
        String name = intent.getStringExtra("appName");
        if (name != null) {
            appName = name;
        } else {
            try {
                appName = (String) BuildConfig.class.getField("APP_NAME").get(null);
            } catch (Exception e) {
                throw new IllegalStateException("使用自动更新组件必须传递appName参数，或者在BuildConfig类中定义");
            }
        }
    }

    private void startDownload() {
        UpdateManager.getInstance().startDownloads(apkUrl, filePath, new UpdateDownloadListener() {
            @Override
            public void onStarted() {
                Log.e("tag", "onStarted()");

            }

            @Override
            public void onProgressChanged(int progress, String downloadUrl) {
                Log.e("onProgressChanged", progress+"");

                notifyUser(getString(R.string.autoupdate_update_download_progressing), getString(R.string.autoupdate_update_download_progressing), progress);
            }

            @Override
            public void onFinished(float completeSize, String downloadUrl) {
                Log.e("tag", "onFinished()");
                notifyUser(getString(R.string.autoupdate_update_download_finish), getString(R.string.autoupdate_update_download_finish), 100);
                stopSelf();
            }

            @Override
            public void onFailure(String error) {
                Log.e("tag", "onFailure()");
                notifyUser(getString(R.string.autoupdate_Update_download_failed), getString(R.string.autoupdate_Update_download_failed), 0);
                stopSelf();
            }
        });
    }

    /**
     * 更新notification
     * @param result
     * @param msg
     * @param progress
     */
    private void notifyUser(String result, String msg, int progress){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(smallIcon)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), icon))
                .setContentTitle(appName);
        if(progress>0 && progress<=100){

            builder.setProgress(100,progress,false);

        }else{
            builder.setProgress(0, 0, false);
        }
        builder.setAutoCancel(true);
        builder.setWhen(System.currentTimeMillis());
        builder.setTicker(result);
        builder.setContentIntent(progress>=100 ? getContentIntent() :
                PendingIntent.getActivity(this, 0, new Intent(), PendingIntent.FLAG_UPDATE_CURRENT));
        notification = builder.build();
        notificationManager.notify(0, notification);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    /**
     * 进入apk安装程序
     * @return
     */
   /* private PendingIntent getContentIntent() {
        Log.e("tag", "getContentIntent()");
        File apkFile = new File(filePath);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setDataAndType(Uri.parse("file://"+apkFile.getAbsolutePath()),
                "application/vnd.android.package-archive");
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        ((Activity)((MyApp)getApplication()).getAttribute("splashActivity")).startActivityForResult(intent,UpdateService.REQUEST_INSTALL);
        ((MyApp)getApplication()).removeAttribute("splashActivity");
        return pendingIntent;

    }*/
    private PendingIntent getContentIntent() {
        Log.e("tag", "getContentIntent()");
        File apkFile = new File(filePath);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setDataAndType(Uri.parse("file://"+apkFile.getAbsolutePath()),
                "application/vnd.android.package-archive");
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        startActivity(intent);
        return pendingIntent;

    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
