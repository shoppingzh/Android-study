package com.littlezheng.ui_layout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LinearLayoutActivity extends AppCompatActivity {

    private Button showRelativeBtn;
    private Button showPercentBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acvitity_linear);

        showRelativeBtn = (Button) findViewById(R.id.show_relative);
        showPercentBtn = (Button) findViewById(R.id.show_percent);

        showRelativeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LinearLayoutActivity.this,RelativeLayoutActivity.class);
                startActivity(intent);
            }
        });

        showPercentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LinearLayoutActivity.this,PercentLayoutActivity.class);
                startActivity(intent);
            }
        });
    }


}
