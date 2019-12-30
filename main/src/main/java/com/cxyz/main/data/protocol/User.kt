package com.cxyz.main.data.protocol

class User (
    // 用户名
    var username:String? = null,
    // 头像
    var headImage:String? = null,
    // 性别
    var sex:String? = null,
    // 用户登录凭证
    var token:String? = null


) {
    override fun toString(): String {
        return "User(username=$username, headImage=$headImage, sex=$sex, token=$token)"
    }
}
