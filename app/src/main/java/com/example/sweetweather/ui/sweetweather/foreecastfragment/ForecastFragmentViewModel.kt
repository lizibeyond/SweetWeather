package com.example.sweetweather.ui.sweetweather.foreecastfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.sweetweather.model.Dailys
import com.example.sweetweather.ui.sweetweather.WeatherRepository

class ForecastFragmentViewModel : ViewModel() {
    private val dailyLiveData = MutableLiveData<String>()

    val dailys: LiveData<Dailys> = Transformations.switchMap(dailyLiveData) {
        WeatherRepository.getDaily(it)
    }

    fun getDailys(cityAxis: String) {
        dailyLiveData.value = cityAxis
    }

}