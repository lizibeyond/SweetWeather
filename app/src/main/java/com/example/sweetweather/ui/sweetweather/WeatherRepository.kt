package com.example.sweetweather.ui.sweetweather

import androidx.lifecycle.MutableLiveData
import com.example.sweetweather.error.SweetError
import com.example.sweetweather.model.Citys
import com.example.sweetweather.model.Dailys
import com.example.sweetweather.model.Weather
import com.example.sweetweather.network.SweetNetWork
import com.example.sweetweather.request.SweetHttpListener

object WeatherRepository {

    /**获取天气对象**/
    fun getWeather(cityAxis :String): MutableLiveData<Weather?> {
        val liveData = MutableLiveData<Weather?>()
        SweetNetWork.getWeather(cityAxis,(object :SweetHttpListener<Weather>(){
            override fun onSucceed(entity: Weather?) {
                liveData.postValue(entity)
            }

            override fun onFeild(error: SweetError?) {

            }
        }))

        return liveData
    }

    /**获取城市坐标**/
    fun getCitys(city :String): MutableLiveData<Citys?> {
        val liveData = MutableLiveData<Citys?>()
        SweetNetWork.getCityData(city,(object :SweetHttpListener<Citys>(){
            override fun onSucceed(entity: Citys?) {
                liveData.postValue(entity)
            }

            override fun onFeild(error: SweetError?) {

            }

        }))
        return liveData
    }

    /**获取未来几天天气信息**/
    fun getDaily(cityAxis :String) : MutableLiveData<Dailys?> {
        val liveData = MutableLiveData<Dailys?>()
        SweetNetWork.getDailyWeather(cityAxis,(object :SweetHttpListener<Dailys>(){
            override fun onSucceed(entity: Dailys?) {
                liveData.postValue(entity)
            }

            override fun onFeild(error: SweetError?) {

            }

        }))
        return liveData
    }
}