package com.littlezheng.surfaceview_demo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.SurfaceHolder;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by zxp on 2017/4/21.
 */

public class PaintThread extends Thread {

    private static final String TAG = "线程"+currentThread().getId();

    private static final int colors[] = {Color.BLUE,Color.CYAN,Color.DKGRAY,Color.GRAY,
            Color.GREEN,Color.LTGRAY,Color.RED,Color.MAGENTA,Color.WHITE,Color.YELLOW};
    private static final float POINT_SIZE = 10;

    private Context context;

    private SurfaceHolder holder;
    private boolean isRunning;
    private boolean hasInit;

    private Canvas canvas;
    private Paint drawPaint;
    private float lastX;
    private float lastY;
    private int maxCanvasWid;
    private int maxCanvasHei;
    private Rect drawRect;

    private float[] points;
    private int[] drawColors;
    private int xCount;
    private int yCount;

    public PaintThread(Context context){
        this.context = context;
    }

    @Override
    public void run() {
        super.run();
        while(true){
            if(isRunning){
//                Log.d(TAG,"画图中...");
                draw();
                //changeColor();
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }
    }

    /**
     * 绘图
     */
    private void draw() {
        synchronized (holder){
//            Log.d(TAG,"上次的坐标：["+lastX+","+lastY+"]");
            drawRect.set((int)lastX,0,(int)(lastX+POINT_SIZE),maxCanvasHei);
            canvas = holder.lockCanvas(drawRect);
//            Log.d(TAG,"当前画布大小：["+canvas.getWidth()+","+canvas.getHeight()+"]");
//            canvas.drawColor(Color.BLUE);

            int len = points.length;
            for (int i=0;i<len;i=i+2){
                drawPaint.setColor(colors[new Random().nextInt(colors.length)]);
                canvas.drawPoint(points[i],points[i+1],drawPaint);
                if(i >= len - 1){break;}
            }
            holder.unlockCanvasAndPost(canvas);

            lastX += POINT_SIZE;
            if(lastX >= maxCanvasWid){
                stopDraw();
            }
            points = getColumn(lastX);
        }
    }

    @Override
    public synchronized void start() {
        //如果线程没有存活，则启动线程，否则，不重复启动线程
        if(!hasInit){
            init();
            this.hasInit = true;
        }
        if(!isAlive()){
            super.start();
        }
        setRunning(true);
    }

    private void init() {
        canvas = holder.lockCanvas();
        canvas.drawColor(Color.BLACK);
        maxCanvasWid = canvas.getWidth();
        maxCanvasHei = canvas.getHeight();
        holder.unlockCanvasAndPost(canvas);

        //初始化画笔
        drawPaint = new Paint();
        drawPaint.setColor(Color.RED);
        drawPaint.setStrokeWidth(POINT_SIZE);
        drawPaint.setAntiAlias(true);
        drawPaint.setDither(true);

//        ColorMatrix cm = new ColorMatrix();
//        cm.setSaturation((float) 0.5);
//        ColorMatrixColorFilter f = new ColorMatrixColorFilter(cm);
//        drawPaint.setColorFilter(f);

        drawRect = new Rect();

        //确定要画的点的数组
        xCount = (int) (maxCanvasWid / POINT_SIZE) + 1;
        yCount = (int) (maxCanvasHei / POINT_SIZE) + 1;
        int len = xCount * yCount * 2;
//        Log.d(TAG,"点的个数："+len);
        points = getColumn(lastX);
        drawColors = new int[len/2];

//        Log.d(TAG,"当前点："+ Arrays.toString(points));
//        Log.d(TAG,"当前点个数："+points.length);
    }

    private float[] getColumn(float x){
        int len = yCount * 2;
        float[] columnDatas = new float[len];
        int y = 0;
        for(int i=0;i<len;i=i+2){
            columnDatas[i] = (int) x;
            columnDatas[i+1] = y;
            y += POINT_SIZE;

            if(i >= len-1){
                break;
            }
        }
        return columnDatas;
    }

    private void changeColor(){
        for(int i=0;i<drawColors.length;i++){
            drawColors[i] = colors[new Random().nextInt(colors.length)];
        }
    }

    /**
     * 重新开始画图
     */
    public void restart(){
        stopDraw();
        clear();
        lastX = 0;
        lastY = 0;
        start();
    }

    private void clear(){
        canvas = holder.lockCanvas();
        canvas.drawColor(Color.BLACK);
        holder.unlockCanvasAndPost(canvas);
    }

    /**
     * 停止画图
     */
    public void stopDraw(){
        setRunning(false);
    }

    public SurfaceHolder getHolder() {
        return holder;
    }

    public void setHolder(SurfaceHolder holder) {
        this.holder = holder;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

}
