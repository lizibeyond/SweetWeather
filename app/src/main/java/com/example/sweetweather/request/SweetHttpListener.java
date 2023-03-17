package com.example.sweetweather.request;

import com.example.sweetweather.error.SweetError;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author Lizi
 * PS: 网络请求监听类，用于监听网络请求
 */
abstract class SweetHttpListener<T> {

    public Type entity;

    public SweetHttpListener(){
        //获取父类的参数类型
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        //可能有多个泛型
        Type[] types = type.getActualTypeArguments();
        entity = types[0];
    }

    /**成功**/
    public abstract void onSucceed(T entuty);
    /**失败**/
    public abstract void onFeild(SweetError error);

}
