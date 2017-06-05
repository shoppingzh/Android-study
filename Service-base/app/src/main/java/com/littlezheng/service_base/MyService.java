package com.littlezheng.service_base;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {

    private static final String TAG = "MyService";

    private DownloadBinder binder;

    public MyService() {
        this.binder = new DownloadBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"服务创建..");
        Toast.makeText(getBaseContext(),"创建服务..",Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"服务启动..");
        Toast.makeText(getBaseContext(),"启动服务..",Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"服务停止..");
        Toast.makeText(getBaseContext(),"停止服务..",Toast.LENGTH_SHORT).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }
}
