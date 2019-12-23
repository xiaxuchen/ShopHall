package com.cxyz.main.ui.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Route
import com.cxyz.main.R
import com.cxyz.main.ui.adapter.CategoryAdapter
import com.cxyz.main.ui.adapter.GoodAdapter
import com.cxyz.utils.MeasureUtil
import com.cxyz.utils.ScreenUtil
import com.qmuiteam.qmui.widget.QMUIRadiusImageView
import kotlinx.android.synthetic.main.main_activity_store_layout.*
@Route(path = "/main/StoreActivity",group = "main")
class StoreActivity : AppCompatActivity() {

    val goodsAdapter = GoodAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_store_layout)
        rvCategory.layoutManager = LinearLayoutManager(this)
        val categoryAdapter = CategoryAdapter(this)
        categoryAdapter.data = listOf("衣服","裤子","羊毛衫","过冬大衣","其他杂七杂八的货品")
        rvCategory.adapter =categoryAdapter
        goodsAdapter.data = listOf("衣服","裤子","羊毛衫","过冬大衣","其他杂七杂八的货品","衣服","裤子","羊毛衫","过冬大衣","其他杂七杂八的货品","衣服","裤子","羊毛衫","过冬大衣","其他杂七杂八的货品")
        rvGoods.apply {
            layoutManager = GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
            addItemDecoration(GoodAdapter.EvenItemDecoration(ScreenUtil.dp2px(context, 20), 2))
            adapter = goodsAdapter
        }
    }
}