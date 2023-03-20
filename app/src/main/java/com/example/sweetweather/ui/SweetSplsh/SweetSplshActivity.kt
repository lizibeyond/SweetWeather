package com.example.sweetweather.ui.SweetSplsh

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import com.example.sweetweather.R
import com.example.sweetweather.base.BaseActivity
import com.example.sweetweather.ui.SweetSearch.SweetSearchActivity

/**
 * @author Lizi
 * PS:四叶草开屏动画界面
 */
class SweetSplshActivity : BaseActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sweet_splsh)
        val btn = findViewById<Button>(R.id.btn)
        btn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        SweetSearchActivity.startAction(this)
    }


}