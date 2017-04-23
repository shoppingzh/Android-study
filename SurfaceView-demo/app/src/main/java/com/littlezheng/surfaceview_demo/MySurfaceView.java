package com.littlezheng.surfaceview_demo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

/**
 * Created by zxp on 2017/4/21.
 */

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    private static final String TAG = "MySurfaceView";
    private SurfaceHolder holder;
    private PaintThread paintThread;

    public MySurfaceView(Context context, AttributeSet attrs,PaintThread paintThread) {
        super(context, attrs);
        this.paintThread = paintThread;
        holder = this.getHolder();
        holder.addCallback(this);

        //为当前线程设置SurfaceHolder
        paintThread.setHolder(holder);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        Log.d(TAG,"Surface被销毁！");
    }
}
