package com.example.sweetweather.ui.SweetWeather

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.sweetweather.R
import com.example.sweetweather.base.BaseActivity
import com.example.sweetweather.error.SweetError
import com.example.sweetweather.log.SweetLog
import com.example.sweetweather.model.Weather
import com.example.sweetweather.network.SweetNetWork
import com.example.sweetweather.request.SweetHttpListener
import com.example.sweetweather.ui.SweetSearch.SweetSearchFragment
import com.example.sweetweather.ui.SweetSearch.SweetSearchViewModel
import com.example.sweetweather.utils.SweetUtils
import okhttp3.internal.wait
import java.util.Objects

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

    companion object {
        /**
         * 跳转到天气主界面
         * @param lat 坐标
         * @param lng 坐标
         */
        @JvmStatic
        fun startWeather(context: Context, lat: String, lng: String) {
            context.startActivity(Intent(context, SweetWeatherActivity::class.java).putExtra("lat",lat).putExtra("lng",lng))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sweet_weather)

        val lat = intent.getStringExtra("lat")
        val lng = intent.getStringExtra("lng")
        if (!SweetUtils.isNullOrEmpty(lat) && !SweetUtils.isNullOrEmpty(lng)){
            val string = java.lang.StringBuilder()
            val cityAxis = string.append(lng).append(",").append(lat)
            SweetWeatherViewModel().setCityAxis(cityAxis.toString())
            SweetNetWork.getWeather(cityAxis.toString(),(object : SweetHttpListener<Weather>() {
                override fun onSucceed(entity: Weather?) {
                    if (entity != null) {
                        SweetLog.d(entity.result.realtime.skycon.toString())
                    }
                }

                override fun onFeild(error: SweetError?) {

                }
            }))
        }
    }


}