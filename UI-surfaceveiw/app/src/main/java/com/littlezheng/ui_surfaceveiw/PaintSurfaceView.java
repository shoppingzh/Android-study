package com.littlezheng.ui_surfaceveiw;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceView;
import android.view.SurfaceHolder;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxp on 2017/4/18.
 */
public class PaintSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    private static final String TAG = "PaintSurfaceView";
    private SurfaceHolder holder;
    private PaintThread paintThread;

    public PaintSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.holder = this.getHolder();
        holder.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        //在此处开启画图线程
        new PaintThread(holder).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Log.d(TAG,"surface大小改变");
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
    }

    /**
     * 可为当前视图提供事件
     * @param l
     */
    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        super.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"点击了视图！");
            }
        });
    }
}
