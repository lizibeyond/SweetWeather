package com.example.sweetweather.ui.sweetweather.weatherfragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.sweetweather.R
import com.example.sweetweather.log.SweetLog
import com.example.sweetweather.model.getSky
import com.example.sweetweather.ui.sweetsearch.SweetSearchActivity
import com.example.sweetweather.ui.sweetweather.SweetWeatherActivity

class SweetWeatherFragment : Fragment() {
    private val viewModel by lazy { ViewModelProvider(this)[WeatherFragmentViewModel::class.java] }

    private lateinit var home: ImageView
    private lateinit var icon: ImageView
    private lateinit var title: TextView
    private lateinit var forecast: TextView
    private lateinit var content: TextView
    private lateinit var bg: FrameLayout
    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var weatherActivity: SweetWeatherActivity

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_weather_wether, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        home = view.findViewById(R.id.weather_home)
        title = view.findViewById(R.id.now_title)
        forecast = view.findViewById(R.id.now_forecast)
        content = view.findViewById(R.id.now_content)
        icon = view.findViewById(R.id.now_icon)
        bg = view.findViewById(R.id.now_framelayout)
        swipeRefresh = view.findViewById(R.id.weather_swiperefresh)

        home.setOnClickListener {
            SweetSearchActivity.startAction(view.context)
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)

        if (activity != null){
            weatherActivity = activity as SweetWeatherActivity
            SweetLog.d(weatherActivity.cityAxis)

            viewModel.weather.observe(viewLifecycleOwner) {
                if (it != null){
                    val temperatyre = it.result.realtime.temperature
                    val skycon = it.result.realtime.skycon
                    val airQuality = it.result.realtime.airQuality.aqi.chn

                    title.text = weatherActivity.city
                    forecast.text = "${temperatyre.toInt()} ℃"
                    content.text = "${getSky(skycon).info} | 空气指数 $airQuality"
                    icon.setImageResource(getSky(skycon).icon)
                    bg.setBackgroundResource(getSky(skycon).bg)
                    swipeRefresh.isRefreshing = false
                }else{
                    Toast.makeText(this.context,"网络异常请稍后重试",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getWeather(weatherActivity.cityAxis)

        swipeRefresh.setOnRefreshListener {
            viewModel.getWeather(weatherActivity.cityAxis)
            swipeRefresh.isRefreshing = true
        }
    }

}