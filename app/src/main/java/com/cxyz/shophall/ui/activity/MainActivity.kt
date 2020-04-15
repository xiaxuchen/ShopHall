package com.cxyz.shophall.ui.activity

import android.view.View
import com.cxyz.mvp.activity.BaseActivity
import com.cxyz.shophall.R
import com.cxyz.shophall.presenter.MainPresenter
import com.cxyz.utils.ImageLoaderManager
import com.cxyz.utils.ToastUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainPresenter>() {
    override fun getContentView(): Any {
        return View.inflate(this,R.layout.activity_main,null)
    }

    override fun initView() {
    }

    override fun initData() {
    }

    override fun setEvent() {
        ImageLoaderManager.init(this)
        ImageLoaderManager.getInstance().displayImage(iv,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1576430875609&di=88e7925b88c8e8fb2b160aca765f580f&imgtype=0&src=http%3A%2F%2Fhbimg.b0.upaiyun.com%2Fb8a2f3cb90ebfdcc8f432e55137d8008d8e0b53c656d-LYlEC1_fw658")
        assert(false)
        ToastUtil.showShort("Hello")
    }

    override fun createIPresenter(): MainPresenter {
        return MainPresenter()
    }

}
