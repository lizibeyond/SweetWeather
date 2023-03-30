package com.example.sweetweather.ui.sweetweather.cubefragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.sweetweather.R
import com.example.sweetweather.log.SweetLog

class CubeFragment : Fragment() {

    companion object {
        fun newInstance() = CubeFragment()
    }

    private val viewModel by lazy { ViewModelProvider(this)[CubeViewModel::class.java] }
    private lateinit var cubeIv: ImageView
    private lateinit var constTv: TextView
    private lateinit var equipIv: ImageView
    private lateinit var basssTv: TextView
    private lateinit var cubeOneTv: TextView
    private lateinit var cubeTwoTv: TextView
    private lateinit var cubeThreeTv: TextView
    private lateinit var cubePlayTv: TextView
    private lateinit var cubeRedIv: ImageView
    private lateinit var cubeBlackIv: ImageView
    private lateinit var cubeSixIv: ImageView
    private lateinit var cubeColorfulIv: ImageView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cube, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //魔方左上图
        cubeIv = view.findViewById(R.id.cube_cube)

        //魔方使用数量
        constTv = view.findViewById(R.id.cube_conts)

        //装备部位图
        equipIv = view.findViewById(R.id.cube_equip)

        //魔方等级
        basssTv = view.findViewById(R.id.cube_basss)

        //魔方词条
        cubeOneTv = view.findViewById(R.id.cube_one)
        cubeTwoTv = view.findViewById(R.id.cube_two)
        cubeThreeTv = view.findViewById(R.id.cube_three)

        //魔方按钮
        cubePlayTv = view.findViewById(R.id.cube_play)

        //魔方选择
        cubeRedIv = view.findViewById(R.id.cube_red)
        cubeBlackIv = view.findViewById(R.id.cube_hei)
        cubeSixIv = view.findViewById(R.id.cube_liu)
        cubeColorfulIv = view.findViewById(R.id.cube_cai)

    }

    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.apply {
            //监听魔方颜色事件
            isCubeColor.observe(viewLifecycleOwner) { cubeColor ->
                when (cubeColor) {
                    0 -> cubeIv.setImageResource(R.drawable.red_cude)
                    1 -> cubeIv.setImageResource(R.drawable.hei_cube)
                    2 -> cubeIv.setImageResource(R.drawable.liujiao_cube)
                    3 -> cubeIv.setImageResource(R.drawable.xuancai_cube)
                }
            }
            //监听魔方使用数量
            cubeConst.observe(viewLifecycleOwner) { i ->
                SweetLog.d("设置数量")
                constTv.text = i.toString()
            }

            //监听词条等级
            cubeLv.observe(viewLifecycleOwner){
                basssTv.text = it.toString() + "级"
            }

            //设置魔方词条
            cubeOne.observe(viewLifecycleOwner){entry ->
                SweetLog.d("设置词条")
                cubeOneTv.text = entry.toString()
            }
            //设置魔方词条
            cubeTwo.observe(viewLifecycleOwner){
                cubeTwoTv.text = it.toString()
            }
            //设置魔方词条
            cubeThree.observe(viewLifecycleOwner){
                cubeThreeTv.text = it.toString()
            }

            //初始化配置页面点击事件
            initOnClick()

        }
    }

    //配置viewmodel
    private fun setViewModel(i: Int) {
        viewModel.apply {
            setCubeColor(i)
            clearCubeConst()
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun initOnClick(){
        //红魔方点击事件
        cubeRedIv.setOnClickListener {
            setViewModel(0)
        }

        //黑魔方点击事件
        cubeBlackIv.setOnClickListener {
            setViewModel(1)
        }

        //六角魔方点击事件
        cubeSixIv.setOnClickListener {
            setViewModel(2)
        }

        //炫彩魔方点击事件
        cubeColorfulIv.setOnClickListener {
            setViewModel(3)
        }

        //魔方使用点击事件
        cubePlayTv.apply {
            setOnTouchListener { v, event ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN ->
                        setTextColor(ContextCompat.getColor(v.context, R.color.black))

                    MotionEvent.ACTION_UP -> {
                        setTextColor(ContextCompat.getColor(v.context, R.color.white))
                        //每点击一次魔方使用数量加1
                        viewModel.setCubeConst()
                        //设置词条
                        viewModel.getCubeEntry()
                    }
                }
                //返回true不向下传递,结束事件
                true
            }
        }
    }
}