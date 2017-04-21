package com.littlezheng.broadcast_custombroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by zxp on 2017/4/19.
 */

public class NetworkChangeBoradcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"网络发生变化！",Toast.LENGTH_SHORT).show();
    }
}
