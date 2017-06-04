package com.littlezheng.notifacation_base;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NotificationClickActivity extends AppCompatActivity {

    private TextView displayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_click);
        displayText = (TextView) findViewById(R.id.text_display);

        Intent intent = getIntent();
        displayText.setText(intent.getStringExtra("content"));

    }
}
