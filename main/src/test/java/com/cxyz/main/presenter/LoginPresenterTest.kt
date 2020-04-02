package com.cxyz.main.presenter

import com.cxyz.main.AndroidRelativeRule
import com.cxyz.main.TestException
import com.cxyz.main.data.model.ILoginModel
import com.cxyz.main.data.model.impl.LoginModelImpl
import com.cxyz.main.presenter.view.ILoginView
import com.cxyz.utils.NetWorkUtil
import com.trello.rxlifecycle2.LifecycleProvider
import org.junit.Before
import org.junit.Test

import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito.*
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner

@RunWith(PowerMockRunner::class)
class LoginPresenterTest {

    @Rule
    @JvmField
    val androidRule = AndroidRelativeRule()

    lateinit var loginPresenter:LoginPresenter

    lateinit var loginModel:ILoginModel

    lateinit var loginView: ILoginView

    @Before
    fun setUp() {
        loginPresenter = LoginPresenter()
        loginModel = mock(ILoginModel::class.java)
        loginView = mock(ILoginView::class.java)
        loginPresenter.mIView = loginView
        loginPresenter.mIModle = loginModel
        //将网络请求工具类模拟，使得能单元测试
        `when`(NetWorkUtil.isNetWorkEnable(any())).thenReturn(true)
    }

    @Test(expected = TestException::class)
    @PrepareForTest(value = arrayOf(NetWorkUtil::class))
    fun login() {
        // 校验
        loginPresenter.login("xxc","12345678")
        verify(loginView).showError(any())
        // 验证调用Model层
        val username = "17478093"
        val password = "12345678"
        `when`(loginModel.verifyUser(username, password))
            .thenThrow(TestException::class.java)
        loginPresenter.login(username,password)
//        verify(loginModel).verifyUser(username, password)
    }
}