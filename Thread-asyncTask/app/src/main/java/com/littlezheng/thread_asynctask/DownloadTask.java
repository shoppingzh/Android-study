package com.littlezheng.thread_asynctask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ProgressBar;

/**.
 * Created by zxp on 2017/6/4.
 */

public class DownloadTask extends AsyncTask<Void,Integer,Boolean> {

    private Context context;

    private ProgressDialog progressDialog;

    public DownloadTask(Context context){
        this.context = context;
        this.progressDialog = new ProgressDialog(context);
    }

    /**
     * 任务开始前要做的事情
     */
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("正在加载配置..");
        progressDialog.show();
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        for(int i=0;i<100;i+=10){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress(i);
        }
        return true;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        progressDialog.setProgress(values[0]);
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        progressDialog.dismiss();
    }

}
