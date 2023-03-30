package com.example.sweetweather.ui.sweetweather.cubefragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sweetweather.dao.getCubeLv
import com.example.sweetweather.dao.getCubeSky
import com.example.sweetweather.log.SweetLog
import kotlin.random.Random

class CubeViewModel : ViewModel() {

    //魔方颜色
    val isCubeColor: LiveData<Int>
        get() = _isCubeColor
    private val _isCubeColor = MutableLiveData<Int>()

    //魔方使用数量
    val cubeConst: LiveData<Int>
        get() = _cubeConst
    private val _cubeConst = MutableLiveData<Int>()

    //词条等级
    val cubeLv: LiveData<String>
        get() = _cubeLv
    private val _cubeLv = MutableLiveData<String>()

    //one词条
    val cubeOne: LiveData<String>
        get() = _cubeOne
    private val _cubeOne = MutableLiveData<String>()

    //two词条
    val cubeTwo: LiveData<String>
        get() = _cubeTwo
    private val _cubeTwo = MutableLiveData<String>()

    //three词条
    val cubeThree: LiveData<String>
        get() = _cubeThree
    private val _cubeThree = MutableLiveData<String>()

    init {
        _isCubeColor.value = 0
        _cubeConst.value = 0
        _cubeOne.value = ""
        _cubeTwo.value = ""
        _cubeThree.value = ""
        _cubeLv.value = "A"
    }

    /**
     * 当前选中的魔方 0红 1黑 2六角 3炫彩
     */
    fun setCubeColor(i: Int) {
        _isCubeColor.value = i
    }

    fun setCubeConst() {
        val const = _cubeConst.value ?: 0
        _cubeConst.value = const + 1
    }

    fun clearCubeConst() {
        _cubeConst.value = 0
        _cubeLv.value = "A"
    }

    /**
     * 随机获取词条
     */
    fun getCubeEntry() {
        val random = Random
        val one = random.nextInt(16)
        val two = random.nextInt(16)
        val three = random.nextInt(16)
        getRandomCubeLv()
        if (one == 6 || one == 8) {
            _cubeOne.value =
                getCubeSky(one) + getCubeLv(random.nextInt(5), cubeLv.value.toString(), true, false)
        } else if (one == 12) {
            _cubeOne.value =
                getCubeSky(one) + getCubeLv(random.nextInt(3), cubeLv.value.toString(), false, true)
        } else {
            _cubeOne.value = getCubeSky(one) + getCubeLv(
                random.nextInt(3),
                cubeLv.value.toString(),
                false,
                false
            )
        }
        if (two == 6 || two == 8) {
            _cubeTwo.value =
                getCubeSky(two) + getCubeLv(random.nextInt(5), cubeLv.value.toString(), true, false)
        } else if (two == 12) {
            _cubeTwo.value =
                getCubeSky(two) + getCubeLv(random.nextInt(3), cubeLv.value.toString(), false, true)
        } else {
            _cubeTwo.value = getCubeSky(two) + getCubeLv(
                random.nextInt(3),
                cubeLv.value.toString(),
                false,
                false
            )
        }
        if (three == 6 || three == 8) {
            _cubeThree.value = getCubeSky(three) + getCubeLv(
                random.nextInt(5),
                cubeLv.value.toString(),
                true,
                false
            )
        } else if (three == 12) {
            _cubeThree.value = getCubeSky(three) + getCubeLv(
                random.nextInt(3),
                cubeLv.value.toString(),
                false,
                true
            )
        } else {
            _cubeThree.value = getCubeSky(three) + getCubeLv(
                random.nextInt(3),
                cubeLv.value.toString(),
                false,
                false
            )
        }

    }

    private fun getRandomCubeLv() {
        val random = Random
        SweetLog.d(_cubeLv.value.toString())
        val index = random.nextInt(100)
        if (index == 10 || index == 18) {
            SweetLog.d(_cubeLv.value.toString())
            if (_cubeLv.value.equals("A")) {
                _cubeLv.value = "S"
            } else if (_cubeLv.value.equals("S")) {
                _cubeLv.value = "SS"
            }
        }
    }
}