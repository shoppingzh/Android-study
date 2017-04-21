package com.littlezheng.broadcast_orderedbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class SecondCustomBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"第二个广播接收器接收到了！",Toast.LENGTH_LONG).show();
    }
}
