package com.example.sweetweather.ui.SweetWeather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author Lizi
 * PS:四叶草天气主界面模型类
 */
class SweetWeatherViewModel : ViewModel() {
    val cityAxis : MutableLiveData<String>
        get() = _cityAxis
    private val _cityAxis = MutableLiveData<String>()

    /**
     * 设置城市坐标
     * @param axis 坐标
     */
    fun setCityAxis(axis :String){
        _cityAxis.postValue(axis)
    }

}