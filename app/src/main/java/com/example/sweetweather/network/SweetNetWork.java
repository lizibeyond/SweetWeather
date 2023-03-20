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

    /**
     * 获取城市信息
     * @param city 要获取得城市
     * @param listener 事件监听
     */
    public static <T> void getCityData(String city,SweetHttpListener<T> listener){
        Map<String,String> map = new LinkedHashMap<>();
        map.put("query",city);
        map.put("token",SweetUrlConsts.CAIYUNTOKEN);
        map.put("lang","zh_CN");
        new SweetHttpRequest().get(SweetUrlConsts.CAIYUNCITYSURL, map, listener);
    }


}
