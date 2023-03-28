package com.example.sweetweather.ui.sweetweather

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.sweetweather.R
import com.example.sweetweather.base.BaseActivity
import com.example.sweetweather.dao.SweetSave
import com.example.sweetweather.log.SweetLog

/**
 * @author Lizi
 * PS: 四叶草天气主界面
 */
class SweetWeatherActivity : BaseActivity() {

    lateinit var cityAxis: String
    lateinit var city: String
    private lateinit var viewPager2: ViewPager2

    /**
     * 跳转到天气主界面
     */
    fun startWeather(context: Context) {
        SweetLog.d("启动weather")
        context.startActivity(
            Intent(context, SweetWeatherActivity::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sweet_weather)

        city = SweetSave.getCity()
        cityAxis = SweetSave.getCityAxis()
        viewPager2 = findViewById(R.id.weather)
        viewPager2.adapter = WeatherAdapter(this)

    }

    override fun onRestart() {
        super.onRestart()
        city = SweetSave.getCity()
        cityAxis = SweetSave.getCityAxis()
        SweetLog.d(city)
    }
}