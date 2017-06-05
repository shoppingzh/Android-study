package com.littlezheng.service_base;

import android.os.Binder;
import android.util.Log;

/**
 * Created by zxp on 2017/6/5.
 */

public class DownloadBinder extends Binder {

    private static final String TAG = "DownloadBinder";

    public void startDownload(){
        Log.d(TAG,"开始下载..");
    }

    public void stopDownload(){
        Log.d(TAG,"停止下载..");
    }

}
