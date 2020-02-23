package com.cxyz.main.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Route
import com.cxyz.main.R
import com.cxyz.main.presenter.StorePresenter
import com.cxyz.main.ui.adapter.CategoryAdapter
import com.cxyz.main.ui.adapter.GoodAdapter
import com.cxyz.mvp.activity.BaseActivity
import com.cxyz.utils.MeasureUtil
import com.cxyz.utils.ScreenUtil
import com.qmuiteam.qmui.widget.QMUIRadiusImageView
import kotlinx.android.synthetic.main.main_activity_store_layout.*
@Route(path = "/main/StoreActivity",group = "main")
class StoreActivity : BaseActivity<StorePresenter>() {
    val goodAdapter = GoodAdapter(this)

    lateinit var storeId:String

    override fun getContentView(): Any {
        return R.layout.main_activity_store_layout
    }

    override fun handleIntent(intent: Intent?) {
        super.handleIntent(intent)
        if (intent == null) {
            throw IllegalAccessException("Show Store fail.You need to specify a string extra named storeId");
        }
        storeId = intent.getStringExtra("storeId")
            ?: throw IllegalAccessException("Show Store fail.You need to specify a string extra named storeId")
        // 加载店铺信息
        iPresenter.getStoreInfo(storeId)
    }

    override fun initView() {
        val categoryAdapter = CategoryAdapter(this)
        categoryAdapter.data = listOf("衣服","裤子","羊毛衫","过冬大衣","其他杂七杂八的货品")
        rvCategory.adapter = categoryAdapter
        rvCategory.layoutManager = LinearLayoutManager(this)
        rvGoods.apply {
            layoutManager = GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
            addItemDecoration(GoodAdapter.EvenItemDecoration(ScreenUtil.dp2px(context, 20), 2))
            adapter = goodAdapter
        }
    }

    override fun initData() {
    }

    override fun setEvent() {
    }

    override fun createIPresenter(): StorePresenter {
        return StorePresenter()
    }

}