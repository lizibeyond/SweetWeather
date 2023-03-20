package com.example.sweetweather.network;

import com.example.sweetweather.consts.SweetUrlConsts;
import com.example.sweetweather.request.SweetHttpListener;
import com.example.sweetweather.request.SweetHttpRequest;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Lizi
 * 四叶草network类
 */
public class SweetNetWork {
    private static Map<String,String> cityMap;
    private static Map<String,String> cityAxisMap;
    /**
     * 获取城市信息
     * @param city 要获取得城市
     * @param listener 事件监听
     */
    public static <T> void getCityData(String city,SweetHttpListener<T> listener){
        if (cityMap == null){
            cityMap  = new LinkedHashMap<>();
        }
        cityMap.put("query",city);
        cityMap.put("token",SweetUrlConsts.CAIYUNTOKEN);
        cityMap.put("lang","zh_CN");
        new SweetHttpRequest().get(SweetUrlConsts.CAIYUNCITYSURL, cityMap,true, listener);
    }

    public static <T> void getWeather(String cityAxis,SweetHttpListener<T> listener){
        if (cityAxisMap == null){
            cityAxisMap = new LinkedHashMap<>();
        }
        cityAxisMap.put("token",SweetUrlConsts.CAIYUNTOKEN);
        cityAxisMap.put("axis",cityAxis);
        cityAxisMap.put("json","realtime.json");
        new SweetHttpRequest().get(SweetUrlConsts.CAIYUNCITYAXISURL,cityAxisMap,false,listener);
    }

}
