package com.littlezheng.broadcast_custombroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by zxp on 2017/4/19.
 */

public class CustomBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = intent.getStringExtra("custom_broadcast_msg");
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }

}
