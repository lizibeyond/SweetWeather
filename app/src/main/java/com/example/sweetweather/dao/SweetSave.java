package com.example.sweetweather.dao;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.sweetweather.application.BaseApplication;

/**
 * @author Lizi
 * 数据存储类
 */
public class SweetSave {

    /**
     * 存储城市数据
     * @param city 城市名
     * @param lat 坐标
     * @param lng 坐标
     */
    public static void saveCityData(String city, String lat, String lng){
        SharedPreferences.Editor editor = BaseApplication.context.getSharedPreferences("data",Context.MODE_PRIVATE).edit();
        editor.putString("city",city).putString("lat",lat).putString("lng",lng).apply();
    }

    /**
     * 获取当前城市
     */
    public static String getCity(){
        SharedPreferences preferences = BaseApplication.context.getSharedPreferences("data",Context.MODE_PRIVATE);
        return preferences.getString("city","");
    }

    /**
     * 获取城市坐标
     */
    public static String getCityAxis(){
        SharedPreferences preferences = BaseApplication.context.getSharedPreferences("data",Context.MODE_PRIVATE);
        if (preferences.getString("lat","").equals("")){
            return "";
        }else {
            return preferences.getString("lng", "") +
                    "," +
                    preferences.getString("lat", "");
        }
    }

    /**
     * 第一次启动保存
     */
    public static void saveFristLanuch(){
        SharedPreferences.Editor editor = BaseApplication.context.getSharedPreferences("data",Context.MODE_PRIVATE).edit();
        editor.putBoolean("fristLaunch",true);
        editor.apply();
    }

    /**
     * 是否是第一次启动app
     */
    public static boolean getFristLanuch(){
        SharedPreferences preferences = BaseApplication.context.getSharedPreferences("data",Context.MODE_PRIVATE);
        return preferences.getBoolean("fristLaunch",false);
    }
}
