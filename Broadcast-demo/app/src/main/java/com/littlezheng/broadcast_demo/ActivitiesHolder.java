package com.littlezheng.broadcast_demo;

import android.app.Activity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxp on 2017/4/20.
 * 设计为单例类
 */

public class ActivitiesHolder {

    private static final String TAG = "ActivitiesHolder";
    private static List<Activity> activityList = new ArrayList<Activity>();

    public static void add(Activity activity){
        Log.d(TAG,"添加一个活动");
        activityList.add(activity);
    }

    public static void destroyAll(){
        for(Activity activity : activityList){
            if(activity!=null && !activity.isFinishing()){
                activity.finish();
            }
        }
        //销毁所有活动后，还应当情况活动列表
        activityList.clear();
    }

    public static int getAcitivitySize(){
        return activityList.size();
    }


}
