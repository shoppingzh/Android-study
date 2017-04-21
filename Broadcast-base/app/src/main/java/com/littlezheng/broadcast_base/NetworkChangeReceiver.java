package com.littlezheng.broadcast_base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by zxp on 2017/4/17.
 */

public class NetworkChangeReceiver extends BroadcastReceiver {

    //接收到广播后的响应逻辑
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"网络发生了变化",Toast.LENGTH_SHORT).show();
    }

}
