package com.cxyz.main.data.model

import com.cxyz.main.AndroidRelativeRule
import com.cxyz.main.data.model.impl.LoginModelImpl
import com.cxyz.main.data.protocol.User
import com.cxyz.relative.base.ext.execute
import com.cxyz.relative.base.rx.BaseSubscriber
import com.cxyz.utils.NetWorkUtil
import io.reactivex.functions.Consumer
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner

@RunWith(PowerMockRunner::class)
class ILoginModelTest {

    @Rule
    @JvmField
    val androidRule = AndroidRelativeRule()

    var loginModel:ILoginModel = LoginModelImpl()

    @Before
    fun setUp() {
        Mockito.`when`(NetWorkUtil.isNetWorkEnable(Mockito.any())).thenReturn(true)
    }

    @Test
    @PrepareForTest(value = arrayOf(NetWorkUtil::class))
    fun verifyUser() {
        loginModel.verifyUser("12345678","12345678").subscribe(object : BaseSubscriber<User>(){
            override fun onNext(t: User) {
                println("haha")
            }

            override fun onError(e: Throwable) {
                e.printStackTrace()
            }
        })
    }
}