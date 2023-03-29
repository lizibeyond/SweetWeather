package com.example.sweetweather.application

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.example.sweetweather.log.SweetLog
import com.example.sweetweather.utils.SweetUtils
import com.tencent.smtt.export.external.TbsCoreSettings
import com.tencent.smtt.sdk.QbSdk
import com.tencent.smtt.sdk.WebView

class BaseApplication : Application() {

    companion object{
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext

        val callback : QbSdk.PreInitCallback = object : QbSdk.PreInitCallback{
            override fun onCoreInitFinished() {

            }

            override fun onViewInitFinished(p0: Boolean) {
                SweetLog.d("X5内核初始化" + p0)
            }

        }
        //初始化X5内核
        QbSdk.initX5Environment(applicationContext,callback)
    }

}