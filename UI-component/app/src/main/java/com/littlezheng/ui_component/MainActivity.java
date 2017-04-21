package com.littlezheng.ui_component;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button showProgressBarBtn;
    private Button showHorProgressBarBtn;
    private Button showAlertDialogBtn;
    private Button showProgressDialogBtn;

    private ProgressBar progressBar;
    private ProgressBar horProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        showProgressBarBtn = (Button) findViewById(R.id.show_progress_bar);
        showHorProgressBarBtn = (Button) findViewById(R.id.show_progress_bar_hor);
        showAlertDialogBtn = (Button) findViewById(R.id.show_alert_dialog);
        showProgressDialogBtn = (Button) findViewById(R.id.show_progress_dialog);

        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        horProgressBar = (ProgressBar) findViewById(R.id.progress_bar_hor);

        //显示进度条
        showProgressBarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(progressBar.isShown()){
                    progressBar.setVisibility(View.GONE);
                }else{
                    progressBar.setVisibility(View.VISIBLE);
                }
            }
        });

        //显示水平进度条
        showHorProgressBarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!horProgressBar.isShown()){
                    horProgressBar.setVisibility(View.VISIBLE);
                }
                if(horProgressBar.getProgress() == horProgressBar.getMax()){
                    horProgressBar.setProgress(0);
                    return;
                }
                horProgressBar.setProgress(horProgressBar.getProgress()+10);

            }
        });

        //显示弹出对话框
        showAlertDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //弹出对话框的实例化方法
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                //弹出对话框的api
                dialog.setTitle("提示");
                dialog.setMessage("这是弹出对话框");
                dialog.setCancelable(true);
                dialog.setIcon(R.mipmap.ic_launcher);
                dialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"点击确认",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });

        //显示进度对话框
        showProgressDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog dialog = new ProgressDialog(MainActivity.this);
                dialog.setMessage("加载中..");
                dialog.show();
            }
        });

    }


}
