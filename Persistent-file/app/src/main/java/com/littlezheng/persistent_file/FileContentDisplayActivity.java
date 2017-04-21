package com.littlezheng.persistent_file;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FileContentDisplayActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_content_display);
        textView = (TextView) findViewById(R.id.text_file_content);

        //显示文件内容
        Intent intent = getIntent();
        if(intent != null){
            String fileContent = intent.getStringExtra("file_content");

            textView.setText(fileContent);
        }
    }
}
