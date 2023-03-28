package com.example.sweetweather.ui.sweetsearch

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.sweetweather.R
import com.example.sweetweather.base.BaseActivity

class SweetSearchActivity : BaseActivity() {
    companion object{
        /**
         * 跳转到搜索页面
         */
        @JvmStatic
        fun startAction(context: Context){
            context.startActivity(Intent(context,SweetSearchActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sweet_search)

        supportFragmentManager.beginTransaction().replace(R.id.search_frame,SweetSearchFragment()).commit()
    }

}