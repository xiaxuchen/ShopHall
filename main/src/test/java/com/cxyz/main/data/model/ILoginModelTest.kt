package com.cxyz.main.data.model

import com.cxyz.main.AndroidRelativeRule
import com.cxyz.main.data.model.impl.LoginModelImpl
import com.cxyz.utils.NetWorkUtil
import org.junit.Test

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
    }
}