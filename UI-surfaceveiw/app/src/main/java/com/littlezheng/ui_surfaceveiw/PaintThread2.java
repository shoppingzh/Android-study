package com.littlezheng.ui_surfaceveiw;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;

import java.util.Iterator;
import java.util.List;

/**
 * Created by zxp on 2017/4/18.
 */

public class PaintThread2 implements Runnable {


    private List<Integer> dataList;

    private static final String TAG = "PaintThread2";
    private SurfaceHolder holder;
    private Canvas canvas;

    public PaintThread2(List<Integer> dataList,SurfaceHolder holder){
        this.dataList = dataList;
        this.holder = holder;
    }

    @Override
    public void run() {
        while(true){
            synchronized (dataList){
                Log.d(TAG,Thread.currentThread().getName()+"开始画图");
                paint();
            }
        }
    }

    private void paint(){
        if(dataList.size() <= 0){
            return;
        }
        canvas = holder.lockCanvas();
        Paint p = new Paint();
        p.setColor(Color.RED);
        p.setStrokeWidth(10);

        Iterator<Integer> iterator = dataList.iterator();
        while(iterator.hasNext()){
            int x = iterator.next();
            canvas.drawPoint(x,100,p);
            iterator.remove();
            Log.d(TAG,"当前x坐标："+x);
        }

        holder.unlockCanvasAndPost(canvas);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
