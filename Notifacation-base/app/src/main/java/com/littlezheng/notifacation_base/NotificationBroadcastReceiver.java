package com.littlezheng.notifacation_base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class NotificationBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"广播接收器接收到内容："+intent.getStringExtra("content"),Toast.LENGTH_SHORT).show();

    }

}
