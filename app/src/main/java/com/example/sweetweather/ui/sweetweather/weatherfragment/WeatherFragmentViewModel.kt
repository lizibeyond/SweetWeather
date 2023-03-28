package com.example.sweetweather.ui.sweetweather.weatherfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.sweetweather.model.Weather
import com.example.sweetweather.ui.sweetweather.WeatherRepository

/**
 * @author Lizi
 * PS:vm类
 */
class WeatherFragmentViewModel : ViewModel() {

    private val weatherLiveData = MutableLiveData<String>()

    val weather : LiveData<Weather> = Transformations.switchMap(weatherLiveData){
        WeatherRepository.getWeather(it)
    }

    fun getWeather(cityAxis: String){
        weatherLiveData.value = cityAxis
    }
}