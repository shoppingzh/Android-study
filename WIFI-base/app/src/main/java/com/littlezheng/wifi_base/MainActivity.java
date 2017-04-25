package com.littlezheng.wifi_base;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity" ;

    private List<ScanResult> scanResults;
    private WifiManager wifiManager;

    private TextView currWifiInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        currWifiInfo = (TextView) findViewById(R.id.text_curr_info);

        findViewById(R.id.btn_scan_result).setOnClickListener(this);
        findViewById(R.id.btn_show_curr_info).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_scan_result:
                scanNetwork();
                break;
            case R.id.btn_show_curr_info:
                showCurrWifiInfo();
                break;
            default:
                break;
        }
    }

    /**
     * 查看当前已连接wifi的信息
     */
    private void showCurrWifiInfo() {
        if (!wifiManager.isWifiEnabled()){
            return;
        }
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        Log.d(TAG,"当前连接信息："+wifiInfo);
        StringBuffer sb = new StringBuffer("当前连接信息：\n");
        sb.append("BSSID：").append(wifiInfo.getBSSID()).append("\n");
        sb.append("MAC地址：").append(wifiInfo.getMacAddress()).append("\n");
        sb.append("SSID：").append(wifiInfo.getSSID()).append("\n");
        sb.append("信号强度：").append(wifiInfo.getRssi()).append("\n");
        sb.append("连接速度：").append(wifiInfo.getLinkSpeed()).append("\n");
        sb.append("ip地址：").append(wifiInfo.getIpAddress()).append("\n");
        sb.append("NetworkId：").append(wifiInfo.getNetworkId()).append("\n");
        sb.append("Supplicant State: ").append(wifiInfo.getSupplicantState()).append("\n");
        currWifiInfo.setText(sb.toString());
    }

    /**
     * 扫描网络并获取结果
     */
    private void scanNetwork() {

        //如果wifi没有被打开，则强制打开wifi
        if (!wifiManager.isWifiEnabled()){
//            wifiManager.setWifiEnabled(true);
            return;
        }

        scanResults = wifiManager.getScanResults();

        Log.d(TAG,"wifi扫描结果："+scanResults);
        Intent intent = new Intent(MainActivity.this,ScanResultShowActivity.class);
//        Bundle bundle = new Bundle();
//        bundle.putParcelableArrayList("scanResults", (ArrayList<? extends Parcelable>) scanResults);
        intent.putParcelableArrayListExtra("scanResults", (ArrayList<? extends Parcelable>) scanResults);
        startActivity(intent);
    }

    /**
     * 获取一个通用进度弹出框
     * @param title
     * @param message
     * @param cancelable
     * @return
     */
    private ProgressDialog getProgressDialog(String title,String message,boolean cancelable){
        ProgressDialog dialog = new ProgressDialog(MainActivity.this);
        dialog.setTitle(title);
        dialog.setMessage(message);
        dialog.setCancelable(cancelable);
        return dialog;
    }


}
