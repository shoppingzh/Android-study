package com.littlezheng.service_base;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.littlezheng.service_base.R.id.btn_stop_service;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button startBtn;
    private Button stopBtn;
    private Button bindBtn;
    private Button unbindBtn;

    private ServiceConnection serviceConnection =
            new ServiceConnection() {
                @Override
                public void onServiceConnected(ComponentName name, IBinder service) {
                    DownloadBinder binder = (DownloadBinder) service;
                    binder.startDownload();
                }

                @Override
                public void onServiceDisconnected(ComponentName name) {

                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn = (Button) findViewById(R.id.btn_start_service);
        stopBtn = (Button) findViewById(btn_stop_service);
        bindBtn = (Button) findViewById(R.id.bind_service);
        unbindBtn = (Button) findViewById(R.id.unbind_service);

        startBtn.setOnClickListener(this);
        stopBtn.setOnClickListener(this);
        bindBtn.setOnClickListener(this);
        unbindBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this,MyService.class);
        switch (v.getId()){
            case R.id.btn_start_service:
                startService(intent);
                break;
            case R.id.btn_stop_service:
                stopService(intent);
                break;
            case R.id.bind_service:
                bindService(intent,serviceConnection,BIND_AUTO_CREATE);
                break;
            case R.id.unbind_service:
                unbindService(serviceConnection);
                break;
        }
    }
}
