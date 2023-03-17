package com.example.sweetweather.request;

import com.example.sweetweather.utils.SweetUtilsKt;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * @author Lizi
 * PS: Http初始化类
 */
public class SweetHttpClient {

    private static OkHttpClient client;

    public static OkHttpClient getClient(){
        if (client == null){
            initOKHttpClient();
        }
        return client;
    }

    /**
     * 初始化OKhttp客户端
     */
    private static void initOKHttpClient(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS);
        //获取主机地址
        String proxyHost = System.getProperty("http.proxyHost");
        //获取端口号
        String proxyPort = System.getProperty("http.proxyPort");

        if (!SweetUtilsKt.isNullOrEmpty(proxyPort) && !SweetUtilsKt.isNullOrEmpty(proxyHost)){
            //设置代理
            builder.proxy(new Proxy(Proxy.Type.HTTP,new InetSocketAddress(proxyHost,Integer.parseInt(proxyPort))));
        }
        client = builder.build();
    }
}
