package com.example.sweetweather.error

/**
 * @author Lizi
 * PS: 四叶草Error类
 */
class SweetError{
    var code = 0
    var message = ""
    var exception = Exception()

    constructor(co:Int,message:String){
        this.code = co
        this.message = message
    }

    constructor(message: String,exception: Exception){
        this.message = message
        this.exception = exception
    }

    companion object {
        /**
         * 获取请求返回的异常信息
         */
        @JvmStatic
        fun getRequestParseError(message: String,exception: Exception) = SweetError(message, exception)

        /**
         * 获取请求返回的错误信息
         */
        @JvmStatic
        fun getRequestFailedError(message: String) = SweetError(-1,message)
    }
}