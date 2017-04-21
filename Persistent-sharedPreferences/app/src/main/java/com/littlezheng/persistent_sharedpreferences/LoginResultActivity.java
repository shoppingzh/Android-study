package com.littlezheng.persistent_sharedpreferences;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LoginResultActivity extends AppCompatActivity {

    private TextView currentUserText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_result);

        currentUserText = (TextView) findViewById(R.id.text_current_user);

        Intent intent = getIntent();
        if(intent != null){
            String currentUserName = intent.getStringExtra("username");
            currentUserText.setText(currentUserName);
        }
    }
}
