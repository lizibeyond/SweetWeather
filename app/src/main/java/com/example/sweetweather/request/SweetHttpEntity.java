package com.example.sweetweather.request;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/**
 * @author Lizi
 * PS: 网络请求实体类,用于返回请求数据
 * T泛型 适配所有返回参数
 */
public class SweetHttpEntity<T> {
    /**返回所有类型参数**/
    @SerializedName("results")
    private T object;

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }

    public String toJson(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
