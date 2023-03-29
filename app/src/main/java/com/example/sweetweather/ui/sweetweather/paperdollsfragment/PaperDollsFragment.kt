package com.example.sweetweather.ui.sweetweather.paperdollsfragment

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import com.example.sweetweather.R
import com.example.sweetweather.consts.SweetUrlConsts
import com.example.sweetweather.log.SweetLog
import com.tencent.smtt.sdk.WebChromeClient
import com.tencent.smtt.sdk.WebSettings
import com.tencent.smtt.sdk.WebView

class PaperDollsFragment : Fragment() {

    companion object {
        fun newInstance() = PaperDollsFragment()
    }

    private lateinit var viewModel: PaperDollsViewModel
    private lateinit var webView: WebView
    private lateinit var paperTv: TextView
    private lateinit var frameLayout: FrameLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_paper_dolls, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PaperDollsViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        paperTv = view.findViewById(R.id.paperdolls_tv)
        frameLayout = view.findViewById(R.id.paperdolls_web)
        paperTv.visibility = View.VISIBLE

        setWebView(view)

    }

    @SuppressLint("SetJavaScriptEnabled")
    fun setWebView(view: View) {
        webView = com.tencent.smtt.sdk.WebView(view.context)
        //设置webview在内页打开
        webView.webViewClient = object : com.tencent.smtt.sdk.WebViewClient() {
            override fun shouldOverrideUrlLoading(
                p0: com.tencent.smtt.sdk.WebView?,
                p1: String?
            ): Boolean {
                p0?.loadUrl(p1)
                return true
            }
        }

        webView.webChromeClient = object : WebChromeClient(){
            override fun onProgressChanged(p0: WebView?, p1: Int) {
                super.onProgressChanged(p0, p1)
                if (p1 == 100){
                    paperTv.visibility = View.GONE
                }
            }
        }

        webView.settings.apply {
            javaScriptEnabled = true //设置js交互
            domStorageEnabled = true //设置缓存
            setSupportZoom(true) //支持缩放
            useWideViewPort = true //自适应屏幕
            defaultTextEncodingName = "utf-8"  //编码
            cacheMode = WebSettings.LOAD_NO_CACHE //缓存模式 不加载缓存
        }

        webView.loadUrl(SweetUrlConsts.PAPERDOLLSURL)
        SweetLog.d("设置webview")
        frameLayout.addView(webView)
    }
}