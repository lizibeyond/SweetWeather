package com.example.sweetweather.log;

import android.util.Log;

/**
 * @author Lizi
 * 四叶草自定义日志类
 */
public class SweetLog {
    public static boolean isLogcat = true;
    public static final String SWEET_LOG = "Sweet";

    public static void v (String string){
        if (isLogcat){
            Log.v(SWEET_LOG,string);
        }
    }
    public static void d (String string){
        if (isLogcat){
            Log.d(SWEET_LOG,string);
        }
    }
    public static void i (String string){
        if (isLogcat){
            Log.i(SWEET_LOG,string);
        }
    }
    public static void e (String string){
        if (isLogcat){
            Log.e(SWEET_LOG,string);
        }
    }
    public static void w (String string){
        if (isLogcat){
            Log.w(SWEET_LOG,string);
        }
    }
}
