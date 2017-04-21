package com.littlezheng.broadcast_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginResultActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_result);

        findViewById(R.id.btn_force_offline).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //用户一旦点击强制下线，则发出一条强制下线的广播
                Intent intent = new Intent("com.littlezheng.broadcast.FORCE_OFF_LINE");
                sendBroadcast(intent);
            }
        });

    }
}
