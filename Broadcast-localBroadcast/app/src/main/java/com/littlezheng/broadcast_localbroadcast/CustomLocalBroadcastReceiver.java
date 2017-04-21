package com.littlezheng.broadcast_localbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by zxp on 2017/4/19.
 */

public class CustomLocalBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"接收到本地广播了！",Toast.LENGTH_SHORT).show();
    }

}
