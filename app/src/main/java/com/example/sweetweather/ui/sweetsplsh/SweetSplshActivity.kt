package com.example.sweetweather.ui.sweetsplsh

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.sweetweather.R
import com.example.sweetweather.base.BaseActivity
import com.example.sweetweather.ui.sweetsearch.SweetSearchActivity

/**
 * @author Lizi
 * PS:四叶草开屏动画界面
 */
class SweetSplshActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sweet_splsh)

        findViewById<TextView>(R.id.sweet_tv).animate().alpha(1f).setDuration(3000).start()

        Handler(Looper.myLooper()!!).postDelayed({
            startActivity(Intent(this,SweetSearchActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        },3500)
    }

}