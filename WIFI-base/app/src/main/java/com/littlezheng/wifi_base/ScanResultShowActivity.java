package com.littlezheng.wifi_base;

import android.content.Intent;
import android.net.wifi.ScanResult;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ScanResultShowActivity extends AppCompatActivity {

    private static final String TAG = "ScanResultShowActivity";

    private Intent fromIntent;
    private List<ScanResult> scanResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_scan_result);

        fromIntent = getIntent();
//        Bundle bundle = fromIntent.getBundleExtra("scanResults");
//        scanResults = bundle.getParcelableArrayList("scanResults");
        scanResults = fromIntent.getParcelableArrayListExtra("scanResults");
        Log.d(TAG,"wifi列表："+scanResults);

        ListView listView = (ListView) findViewById(R.id.list_scan_result);
        listView.setAdapter(new ArrayAdapter<ScanResult>(ScanResultShowActivity.this,android.R.layout.simple_list_item_1,scanResults));

    }
}
