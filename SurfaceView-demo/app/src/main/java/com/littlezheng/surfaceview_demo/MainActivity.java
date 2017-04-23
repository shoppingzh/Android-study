package com.littlezheng.surfaceview_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private SurfaceView mySurfaceView;
    private PaintThread paintThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        paintThread = new PaintThread(getBaseContext());
        mySurfaceView = new MySurfaceView(getBaseContext(),null,paintThread);

        LinearLayout layout = (LinearLayout) findViewById(R.id.layout_display);
        layout.addView(mySurfaceView);

        findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintThread.start();
            }
        });

        findViewById(R.id.btn_stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintThread.stopDraw();
            }
        });

        findViewById(R.id.btn_exit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        findViewById(R.id.btn_restart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintThread.restart();
            }
        });

    }
}
