package com.cxyz.main.presenter

import com.cxyz.main.data.model.IStoreModel
import com.cxyz.main.data.model.impl.StoreModelImpl
import com.cxyz.main.presenter.view.IStoreView
import com.cxyz.mvp.ipresenter.IBasePresenter

class StorePresenter : IBasePresenter<IStoreModel,IStoreView>() {
    override fun createModel(): IStoreModel {
        return StoreModelImpl()
    }

    /**
     * 根据id获取商铺的信息
     */
    fun getStoreInfo (id: String) {

    }
}