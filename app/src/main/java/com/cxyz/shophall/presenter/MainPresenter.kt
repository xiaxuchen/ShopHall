package com.cxyz.shophall.presenter

import com.cxyz.mvp.ipresenter.IBasePresenter
import com.cxyz.shophall.model.MainModel
import com.cxyz.shophall.presenter.view.MainView

class MainPresenter : IBasePresenter<MainModel,MainView>() {
    override fun createModel(): MainModel {
        return MainModel()
    }
}