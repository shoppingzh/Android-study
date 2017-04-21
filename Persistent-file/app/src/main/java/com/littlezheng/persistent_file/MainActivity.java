package com.littlezheng.persistent_file;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText fileContentInput;
    private EditText fileNameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fileContentInput = (EditText) findViewById(R.id.input_file_content);
        fileNameInput = (EditText) findViewById(R.id.input_file_name);

        //写入文件
        findViewById(R.id.btn_write_file).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fileContent = fileContentInput.getText().toString();
                String fileName = fileNameInput.getText().toString();

                OutputStream out = null;
                try {
                    out = openFileOutput(fileName,MODE_PRIVATE);
                    BufferedWriter writer
                            = new BufferedWriter(new OutputStreamWriter(out,"utf-8"));
                    writer.write(fileContent);
                    writer.flush();
                    Toast.makeText(getBaseContext(),"写入文件成功！",Toast.LENGTH_SHORT).show();

                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(getBaseContext(),"写入文件失败！",Toast.LENGTH_SHORT).show();
                }

            }
        });

        //读取文件
        findViewById(R.id.btn_read_file).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputStream in = null;
                try {
                    //获取文件的所有内容
                    in = openFileInput(fileNameInput.getText().toString());
                    BufferedReader reader =
                            new BufferedReader(new InputStreamReader(in,"utf-8"));
                    StringBuffer sb = new StringBuffer();
                    String line = null;
                    while((line=reader.readLine()) != null){
                        sb.append(line).append("\n");
                    }

                    //将文件显示在下一个活动上
                    Intent intent = new Intent(getBaseContext(),FileContentDisplayActivity.class);
                    intent.putExtra("file_content",sb.toString());
                    startActivity(intent);

                }catch (FileNotFoundException e1){
                    Toast.makeText(getBaseContext(),"文件找不到",Toast.LENGTH_SHORT).show();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
