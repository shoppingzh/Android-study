package com.littlezheng.ui_listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private String[] peoples = new String[100];

    {
        for(int i=0;i<100;i++){
            peoples[i] = "郑晓平 - "+i;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        Log.d("Main", Arrays.toString(peoples));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_list_item_1,peoples);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        //为列表项添加事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),"当前点击的是："+peoples[position],Toast.LENGTH_SHORT).show();
                if(position == 0){
                    Intent intent = new Intent(getBaseContext(),MultipartListViewActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
