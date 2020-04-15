package com.cxyz.relative.base.starter;

import android.accounts.NetworkErrorException;
import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.FileUtils;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.cxyz.context.starter.Starter;
import com.cxyz.http.CommonOkHttpClient;
import com.cxyz.http.controller.CallController;
import com.cxyz.http.listener.DisposeDataHandler;
import com.cxyz.http.listener.DisposeDataListener;
import com.cxyz.http.request.RequestParams;
import com.cxyz.utils.ActivityStackManager;
import com.cxyz.utils.FileUtil;
import com.cxyz.utils.LogUtil;
import com.cxyz.utils.SpUtil;
import com.cxyz.utils.ToastUtil;
import com.kotlin.base.common.BaseConstant;
import com.wanjian.cockroach.Cockroach;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

// TODO 需要一个Service在启动应用的时候去完成上传bug的任务
public class ExceptionHandlerStarter implements Starter {

    // 上传bug的路径
    private static final String BUG_URL = BaseConstant.getSERVER_ADDRESS() + "/bugs";

    private static final String LAST_RESTART_TIME = "lastRestartTime";

    @Override
    public void load(Context context) {
        Cockroach.install((thread, throwable) -> {
            // 打印异常
            LogUtil.e(Log.getStackTraceString(throwable));
            // 这里可以添加上传异常信息的代码
            ToastUtil.showShort("发生未知异常");
            if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                return;
            }
            //以当前时间创建log文件
            try {
                //输出流操作,将日志保存在/bugs/目录
                File tempFile = new File(context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS).getAbsolutePath(), "bugs/" + UUID.randomUUID().toString().replace('-','_')+".log");
                createContent(context,tempFile,throwable);
                restart(context);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * 创建日志内容
     * @param context
     * @param tempFile
     * @param throwable
     * @return
     */
    private String createContent(Context context,File tempFile,Throwable throwable) {
        //获取当前时间
        long current = System.currentTimeMillis();
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(current));
        PrintWriter pw = null;
        BufferedReader bufferedReader = null;
        try {
            pw = new PrintWriter(new BufferedWriter(new FileWriter(tempFile)));
            //导出手机信息和异常信息
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), PackageManager.GET_ACTIVITIES);
            pw.println("发生异常时间：" + time);
            pw.println("应用版本：" + pi.versionName);
            pw.println("应用版本号：" + pi.versionCode);
            pw.println("android版本号：" + Build.VERSION.RELEASE);
            pw.println("android版本号API：" + Build.VERSION.SDK_INT);
            pw.println("手机制造商:" + Build.MANUFACTURER);
            pw.println("手机型号：" + Build.MODEL);
            throwable.printStackTrace(pw);
            bufferedReader = new BufferedReader(new FileReader(tempFile));
            StringBuffer buffer = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                buffer.append(line);
            }
            return buffer.toString();
        }catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(pw!=null)
                pw.close();
            if(bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

//    private void uploadBug(Context context,String content,File tempFile) {
//        // 如果内容为空，直接重启或杀死
//        if(content == null)
//        {
//            restart(context);
//            return;
//        }
//        new Thread(() -> {
//            System.out.println("hello");
//        }).start();
//        new Thread(() -> {
//            System.out.println("hello");
//        }).start();
//        try {
//            final CallController call = CommonOkHttpClient.post(BUG_URL, RequestParams.create("content", content), new DisposeDataHandler(new DisposeDataListener() {
//                @Override
//                public void onSuccess(Object responseObj) {
//                    tempFile.delete();
//                }
//
//                @Override
//                public void onFailure(Object error) {
//                }
//            }));
//        } catch (NetworkErrorException e) {
//            e.printStackTrace();
//        }
//    }

    private void restart(Context context) {
        long now = System.currentTimeMillis();
        // 如果不超过两分钟就不重启直接杀了
        if (((now - SpUtil.getInstance().getLong(LAST_RESTART_TIME, 0))/1000/60 < 2)) {
            ActivityStackManager.getActivityStackManager().exitApp();
            return;
        }

        SpUtil.getInstance().putLong(LAST_RESTART_TIME,now);

        Application application = (Application) context;
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent restartIntent = PendingIntent.getActivity(
                application.getApplicationContext(), 0, intent,PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager mgr = (AlarmManager)application.getSystemService(Context.ALARM_SERVICE);
        mgr.set(AlarmManager.RTC, now + 1000,
                restartIntent); // 1秒钟后重启应用
        ActivityStackManager.getActivityStackManager().exitApp();
    }

    @Override
    public void onDestroy() {
        Cockroach.uninstall();
    }
}