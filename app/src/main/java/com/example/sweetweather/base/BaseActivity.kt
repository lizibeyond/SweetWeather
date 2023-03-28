package com.example.sweetweather.base

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        //安卓28以上版本挖孔屏,适配全屏
        if (Build.VERSION.SDK_INT >= 28) {
            window.attributes.layoutInDisplayCutoutMode =
                WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
            val controller = ViewCompat.getWindowInsetsController(window.decorView)
            controller?.hide(WindowInsetsCompat.Type.navigationBars())
        }
        //设置导航栏颜色
        window.navigationBarColor = Color.TRANSPARENT
        //设置顶部栏透明
        window.statusBarColor = Color.TRANSPARENT
        //设置隐藏系统UI
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
        super.onCreate(savedInstanceState)
    }

}