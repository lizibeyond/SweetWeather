package com.example.sweetweather.ui.sweetweather

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.sweetweather.ui.sweetweather.cubefragment.CubeFragment
import com.example.sweetweather.ui.sweetweather.foreecastfragment.SweetForecastFragment
import com.example.sweetweather.ui.sweetweather.paperdollsfragment.PaperDollsFragment
import com.example.sweetweather.ui.sweetweather.weatherfragment.SweetWeatherFragment

class WeatherAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment = when(position){
        0 -> SweetWeatherFragment()
        1 -> SweetForecastFragment()
        2 -> PaperDollsFragment()
        3 -> CubeFragment()
        else -> {
            SweetWeatherFragment()
        }
    }

}