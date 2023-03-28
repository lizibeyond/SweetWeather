package com.example.sweetweather.ui.sweetsearch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sweetweather.model.Citys

class SweetSearchViewModel : ViewModel() {

    val city: LiveData<Citys>
        get() = _city

    private val _city = MutableLiveData<Citys>()
    fun setCity(city: Citys) {
        _city.postValue(city)
    }

}