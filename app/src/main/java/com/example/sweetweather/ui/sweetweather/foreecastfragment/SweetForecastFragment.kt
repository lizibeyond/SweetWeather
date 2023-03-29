package com.example.sweetweather.ui.sweetweather.foreecastfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.sweetweather.R
import com.example.sweetweather.log.SweetLog
import com.example.sweetweather.model.getSky
import com.example.sweetweather.ui.sweetweather.SweetWeatherActivity
import de.hdodenhof.circleimageview.CircleImageView
import java.text.SimpleDateFormat
import java.util.Locale

@Suppress("NAME_SHADOWING")
class SweetForecastFragment : Fragment() {
    private val viewModel by lazy { ViewModelProvider(this)[ForecastFragmentViewModel::class.java] }
    private lateinit var weatherActivity: SweetWeatherActivity
    private lateinit var paperDollsImg : CircleImageView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_wether_forecast_life, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val forecastFramelayout: LinearLayout = view.findViewById(R.id.forecast_linearlayout)
        paperDollsImg = view.findViewById(R.id.paperdolls_btn)


        if (activity != null) {
            weatherActivity = activity as SweetWeatherActivity
            viewModel.getDailys(weatherActivity.cityAxis)

            paperDollsImg.setOnClickListener {
            }

            viewModel.dailys.observe(viewLifecycleOwner) {
                val dailySize = it.result.daily.skycon.size
                val dailys = it.result.daily
                //清除存在的视图
                forecastFramelayout.removeAllViews()
                for (i in 0 until dailySize) {
                    val view = LayoutInflater.from(context)
                        .inflate(R.layout.forecast_item, forecastFramelayout, false)
                    val date = SimpleDateFormat(
                        "yy-MM-dd",
                        Locale.getDefault()
                    ).format(dailys.skycon[i].date)

                    SweetLog.d(date.toString())
                    val temperature =
                        dailys.temperature[i].min.toInt().toString() + " ~ " + dailys.temperature[i].max.toInt() + " ℃"
                    view.findViewById<TextView>(R.id.forecast_temperature).text = temperature

                    view.findViewById<TextView>(R.id.forecast_date).text = date.toString()

                    view.findViewById<ImageView>(R.id.forecast_img)
                        .setImageResource(getSky(dailys.skycon[i].value).icon)

                    view.findViewById<TextView>(R.id.forecast_info).text =
                        getSky(dailys.skycon[i].value).info
                    //填充视图
                    forecastFramelayout.addView(view)
                }

                view.findViewById<TextView>(R.id.coldrisk_tv).text =
                    dailys.lifeIndex.coldRisk[0].desc
                view.findViewById<TextView>(R.id.dressing_tv).text =
                    dailys.lifeIndex.dressing[0].desc
                view.findViewById<TextView>(R.id.ultraviolet_tv).text =
                    dailys.lifeIndex.ultraviolet[0].desc
                view.findViewById<TextView>(R.id.carwashing_tv).text =
                    dailys.lifeIndex.carWashing[0].desc

            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getDailys(weatherActivity.cityAxis)
    }

}