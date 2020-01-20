package com.cxyz.main.ui.adapter

import android.content.Context
import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cxyz.context.ContextManager
import com.cxyz.main.R
import com.cxyz.main.ext.inflateHolderView
import com.cxyz.mvp.adapter.BaseRecycleViewAdapter
import com.cxyz.utils.ScreenUtil
import com.qmuiteam.qmui.layout.QMUILinearLayout
import com.qmuiteam.qmui.widget.QMUIRadiusImageView

class GoodAdapter (context:Context):
    BaseRecycleViewAdapter<String, GoodAdapter.GoodHolder>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoodHolder {
        return GoodHolder(inflateHolderView(R.layout.main_recycle_item_goods_layout,parent))
    }

    class GoodHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val ivGood:QMUIRadiusImageView = view.findViewById(R.id.ivGood)

        val tvGoodName:TextView = view.findViewById(R.id.tvGoodName)

        init {
            (view as QMUILinearLayout).setRadiusAndShadow(ScreenUtil.dp2px(ContextManager.getContext(),3),ScreenUtil.dp2px(ContextManager.getContext(),20),0.35f)
        }
    }

    class EvenItemDecoration(private val space: Int, private val column: Int) : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            val position = parent.getChildAdapterPosition(view)
            // 每个span分配的间隔大小
            val spanSpace = space * (column + 1) / column
            // 列索引
            val colIndex = position % column
            // 列左、右间隙
            outRect.left = space * (colIndex + 1) - spanSpace * colIndex
            outRect.right = spanSpace * (colIndex + 1) - space * (colIndex + 1)
            // 行间距
            if (position >= column) {
                outRect.top = space
            }
        }
    }
}