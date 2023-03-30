package com.example.sweetweather.dao

import com.example.sweetweather.log.SweetLog

private val cubeSky = mapOf(
    0 to "力量 +",
    1 to "智力 +",
    2 to "敏捷 +",
    3 to "运气 +",
    4 to "攻击力 +",
    5 to "魔法攻击力 +",
    6 to "攻击首领伤害 +",
    7 to "暴击率 +",
    8 to "无视怪物防御力 +",
    9 to "伤害 +",
    10 to "最大魔量 +",
    11 to "最大血量 +",
    12 to "所有技能冷却时间 -",
    13 to "金币获得量 +",
    14 to "防御力 +",
    15 to "全属性 +"
)

private val cubeALv = mapOf(
    0 to "3%",
    1 to "6%",
    2 to "3%"
)

private val cubeSLv = mapOf(
    0 to "3%",
    1 to "6%",
    2 to "9%",
)

private val cubeSSLv = mapOf(
    0 to "6%",
    1 to "9%",
    2 to "12%"
)

private val cubeABoss = mapOf(
    0 to "10%",
    1 to "15%",
    2 to "10%",
    3 to "15%",
    4 to "10%"
)

private val cubeSBoss = mapOf(
    0 to "15%",
    1 to "20%",
    2 to "25%",
    3 to "30%",
    4 to "15%"
)

private val cubeSSBoss = mapOf(
    0 to "20%",
    1 to "25%",
    2 to "30%",
    3 to "35%",
    4 to "40%"
)

private val cubeCD = mapOf(
    0 to "1",
    1 to "2",
    2 to "1",
    3 to "2",
    4 to "1"
)

/**
 * 获取词条
 */
fun getCubeSky(i: Int): String {
    SweetLog.d(i.toString() + "随机")
    return cubeSky[i].toString()
}

fun getCubeLv(i: Int, lv: String, isBoss: Boolean, isCD: Boolean): String {
    SweetLog.d(i.toString() + "随机2")
    return when (lv) {
        "A" -> {
            if (isBoss) {
                cubeABoss[i].toString()
            } else {
                cubeALv[i].toString()
            }
        }
        "S" -> {
            if (isBoss) {
                cubeSBoss[i].toString()
            } else {
                cubeSLv[i].toString()
            }
        }
        "SS" -> {
            if (isBoss) {
                cubeSSBoss[i].toString()
            } else if (isCD) {
                cubeCD[i].toString()
            } else {
                cubeSSLv[i].toString()
            }
        }
        else -> cubeALv[i].toString()
    }
}