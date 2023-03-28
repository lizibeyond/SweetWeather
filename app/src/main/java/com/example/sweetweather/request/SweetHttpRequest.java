package com.example.sweetweather.request;

import android.net.Uri;

import androidx.annotation.NonNull;

import com.example.sweetweather.error.SweetError;
import com.example.sweetweather.log.SweetLog;
import com.example.sweetweather.utils.SweetUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author Lizi
 * PS: 网络请求发起类，用于发起网络请求
 */
public class SweetHttpRequest {
    private Gson gson;

    /**
     * 默认不使用公共参数
     * @param url 地址
     * @param map 参数
     * @param listener 监听
     * @param isTwo 2.0 true/2.5 false
     */
    public <T> void get(String url,Map<String,String> map,boolean isTwo, SweetHttpListener<T> listener){
        get(url,map,isTwo,false,listener);
    }

    /**
     * 默认不使用公共参数
     * @param url 地址
     * @param map 参数
     * @param listener 监听
     * @param isAddPublicParameters 是否使用公共参数
     */
    public <T> void get(String url, Map<String,String> map,boolean isTwo,boolean isAddPublicParameters, SweetHttpListener<T> listener){
        if (SweetUtils.isNullOrEmpty(url) || map.isEmpty()){
            return;
        }
        if (isAddPublicParameters){
            addPublicParameters(map);
        }
        String requestUrl = url + mapToParsString(map,isTwo,false);
        SweetLog.d(requestUrl);
        final Request request = new Request.Builder().url(requestUrl).build();
        SweetHttpClient.getClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                listener.onFeild(new SweetError("操作失败请稍后重试",e));
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (gson == null){
                    gson = new GsonBuilder().excludeFieldsWithModifiers(Modifier.FINAL,Modifier.TRANSIENT,Modifier.STATIC).create();
                }
                T entity;
                final String body;
                if (response.body() != null){
                    body = response.body().string();
                    try{
                        entity = gson.fromJson(body,listener.entity);
                    }catch (Exception e){
                        try{
                            String finalBody = body.replaceAll("\\[\\]","null");
                            entity = gson.fromJson(finalBody,listener.entity);
                        }catch (Exception e1){
                            listener.onFeild(SweetError.getRequestFailedError("操作失败请稍后重试"));
                            return;
                        }
                    }
                    listener.onSucceed(entity);
                }else {
                    listener.onFeild(SweetError.getRequestFailedError("操作失败请稍后重试"));
                }
            }
        });
    }

    /**
     * post请求不使用公共参数
     * @param url 地址
     * @param map 参数
     * @param listener 监听
     */
    public <T> void post(String url,Map<String,String> map,SweetHttpListener<T> listener){
        post(url,map,false,listener);
    }

    /**
     * post请求
     * @param url 地址
     * @param map 参数
     * @param listener 监听
     * @param isAddPublicParameters 是否使用公共参数
     */
    public <T> void post(String url,Map<String,String> map,boolean isAddPublicParameters,SweetHttpListener<T> listener){
        if (SweetUtils.isNullOrEmpty(url) || map.isEmpty()){
            return;
        }
        if (isAddPublicParameters){
            addPublicParameters(map);
        }
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String,String> entry: map.entrySet()) {
            if (entry.getValue() == null){
                //null值会让框架挂掉
                entry.setValue("");
            }
            builder.add(entry.getKey(), entry.getValue());
        }

        final Request request = new Request.Builder().url(url).post(builder.build()).build();

        SweetHttpClient.getClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                listener.onFeild(SweetError.getRequestFailedError("操作失败请稍后重试"));
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (gson == null){
                    gson = new Gson();
                }
                if (response.body() != null){
                    final String body = response.body().string();
                    T entity;
                    try{
                        entity = gson.fromJson(body,listener.entity);
                    }catch (Exception e){
                        try{
                            String finalBody = body.replaceAll("\\[\\]","null");
                            entity = gson.fromJson(finalBody,listener.entity);
                        }catch (Exception e1){
                            listener.onFeild(SweetError.getRequestFailedError("操作失败请稍后重试"));
                            return;
                        }
                    }
                    listener.onSucceed(entity);
                }else {
                    listener.onFeild(SweetError.getRequestFailedError("操作失败请稍后重试"));
                }
            }
        });
    }


    /**
     * 添加公共参数
     * @param map 传入要添加公共参数的map
     */
    private void addPublicParameters(Map<String,String> map){
        map.put("","");
    }

    /**
     * 将map拼接成String
     * @param map 传入要转换得map
     * @param isEncode 是否加密
     */
    private String mapToParsString(Map<String,String> map, boolean isEncode){

        StringBuilder builder = new StringBuilder();
        int index = 1;
        for (String e: map.keySet()) {
            builder.append(e).append("=").append(isEncode ? Uri.encode(map.get(e)) : map.get(e));
            if (map.size() != index){
                builder.append("&");
            }
            index++;
        }
        return builder.toString();
    }

    /**
     * 将map拼接成String
     * @param map 传入要转换得map
     * @param isEncode 是否加密
     * @param isTwo 选择拼接版本
     */
    private String mapToParsString(Map<String,String> map,boolean isTwo, boolean isEncode){
        StringBuilder builder = new StringBuilder();
        if (isTwo){
            int index = 1;
            builder.append("?");
            for (String e: map.keySet()) {
                builder.append(e).append("=").append(isEncode ? Uri.encode(map.get(e)) : map.get(e));
                if (map.size() != index){
                    builder.append("&");
                }
                index++;
            }
            return builder.toString();
        }else {
            for (String e : map.values()){
                builder.append("/").append(e);
            }
            return builder.toString();
        }

    }
}
