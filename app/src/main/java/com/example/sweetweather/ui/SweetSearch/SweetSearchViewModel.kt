package com.example.sweetweather.ui.SweetSearch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sweetweather.model.Citys

class SweetSearchViewModel : ViewModel() {

    val city: LiveData<Citys>
        get() = _city

    companion object{
        private val _city = MutableLiveData<Citys>()
        @JvmStatic
        fun setCity(city: Citys) {
            _city.postValue(city)
        }
    }

}