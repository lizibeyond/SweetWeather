package com.example.sweetweather.ui.SweetWeather

import android.os.Bundle
import com.example.sweetweather.R
import com.example.sweetweather.base.BaseActivity

/**
 * @author Lizi
 * PS: 四叶草天气主界面
 */
class SweetWeatherActivity : BaseActivity() {

    override fun onStart() {
        super.onStart()
        //将当前界面添加到list中统一管理
        addActivity(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sweet_weather)
    }
}