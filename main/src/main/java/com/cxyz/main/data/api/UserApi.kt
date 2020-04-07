package com.cxyz.main.data.api

import com.cxyz.http.request.RequestParams
import com.cxyz.main.data.api.const.USER_LOGIN
import com.cxyz.main.data.api.const.USER_VERIFY_CODE
import com.cxyz.main.ext.createObservable
import com.cxyz.relative.base.data.protocol.BaseResp
import com.cxyz.relative.base.data.protocol.User
import com.google.gson.reflect.TypeToken
import io.reactivex.Observable

object UserApi {

    /**
     * 用户登录
     */
    fun login (username:String,password:String):Observable<User> {
        return createObservable(
            USER_LOGIN,
            RequestParams(mapOf<String,String>("username" to username,"password" to password)),
            // 所有调用createObservable都加上最后这个参数吧，我去洗澡了
            // 这里是返回类型，对应，懂了吗 ，改就是了，中间做了很多操作，
            // 把Json转化为BaseResp<User>类型的对象，由于泛型擦除，只能以这种写法
            // Gson才能知道正确的对象转换类型，Gson的TypeToken，然后他才会转换出带泛型的对象
            // 如果直接传入class，你只能传递一个BaseResp
            // 刚刚我的问题是，我认为kotlin能够给我在编译的时候将泛型复制，(它的inline函数就是复制的)
            // 但是他没有，它仍然传递了一个BaseResp<T>给Gson，Gson无法理解，就按照Object去转换，
            // 转换成Gson内部的什么JsonLinkedTree，然后在回调到onNext的时候，强制转换出错，就崩了，
            // 我现在怕的是其他使用了createObservable的地方出现同样的问题，所以让你改一下
            // 按住ctrl可以查看函数的引用，ctrl + t 跳转到方法、类的实现你先搞
            (object :TypeToken<BaseResp<User>>(){}).type
            )
    }

    /**
     * 发送验证码
     */
    fun sendVerifyCode(phone:String):Observable<Any> {
        return createObservable(USER_VERIFY_CODE,
            RequestParams(mapOf<String,String>("phone" to phone))
        )
    }

    /**
     * 注册
     */
    fun register (phone: String, password: String, verifyCode: String):Observable<Any> {
        return createObservable(USER_VERIFY_CODE,
            RequestParams(mapOf<String,String>("phone" to phone,"password" to password,"verifyCode" to verifyCode)))
    }


}
