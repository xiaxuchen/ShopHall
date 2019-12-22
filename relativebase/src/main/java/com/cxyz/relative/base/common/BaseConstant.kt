package com.kotlin.base.common

/*
    基础常量
 */
class BaseConstant{
    companion object {
        //七牛服务地址
        @JvmStatic
        val IMAGE_SERVER_ADDRESS = "http://osea2fxp7.bkt.clouddn.com/"
        //本地服务器地址
        @JvmStatic
        val SERVER_ADDRESS = "http://10.28.14.168:8080"
        //SP表名
        @JvmStatic
        val TABLE_PREFS = "Kotlin_mall"
        //Token Key
        @JvmStatic
        val KEY_SP_TOKEN = "token"
    }
}
