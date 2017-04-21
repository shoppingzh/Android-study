package com.littlezheng.broadcast_demo;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;

public class ForceOfflineBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, Intent intent) {
        //接收到强制下线的广播，弹出对话框
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setCancelable(false);
        alertDialog.setTitle("警告");
        alertDialog.setMessage("您的账号已在别处登录，现已被强制下线！");
        alertDialog.setNegativeButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //点击确认后，重新回到登录界面
                Intent intent = new Intent(context,MainActivity.class);
                context.startActivity(intent);
            }
        });
        alertDialog.show();
    }
}
