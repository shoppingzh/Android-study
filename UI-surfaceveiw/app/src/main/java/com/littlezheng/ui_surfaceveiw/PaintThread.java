package com.littlezheng.ui_surfaceveiw;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.SurfaceHolder;

import java.util.Random;

/**
 * Created by zxp on 2017/4/18.
 */

public class PaintThread extends Thread {

    private static final String TAG = "PaintThread";
    private SurfaceHolder holder;
    private Canvas canvas;

    public PaintThread(SurfaceHolder holder){
        this.holder = holder;
    }

    @Override
    public void run() {
        super.run();
        Log.d(TAG,Thread.currentThread().getName()+"开始画图");

        canvas = holder.lockCanvas();
        int wid = canvas.getWidth(),hei = canvas.getHeight();
        Log.d(TAG,"当前画布尺寸："+wid+","+hei);
        Paint p = new Paint();
        p.setColor(Color.RED);
        p.setTextSize(50);
        p.setStrokeWidth(10);
        canvas.drawText("如何画一个x？",0,50,p);
        holder.unlockCanvasAndPost(canvas);

        Rect rect = new Rect(100,70,wid-100,hei-100);
        canvas = holder.lockCanvas(rect);
        Log.d(TAG,"写完文字后的画布尺寸："+rect.width()+","+rect.height());
        canvas.drawColor(Color.GRAY);
        holder.unlockCanvasAndPost(canvas);

        canvas = holder.lockCanvas(rect);
        p.setColor(Color.RED);
        canvas.drawLine(0,100,wid,hei,p);
        canvas.drawLine(0,hei,wid,0,p);
        holder.unlockCanvasAndPost(canvas);

    }
}
