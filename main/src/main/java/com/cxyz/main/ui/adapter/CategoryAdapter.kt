package com.cxyz.main.ui.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cxyz.main.R
import com.cxyz.mvp.adapter.BaseRecycleViewAdapter

class CategoryAdapter (context:Context,checked:Int = 0):BaseRecycleViewAdapter<String,CategoryAdapter.CategoryHolder>(context) {

    private var checked:Int = checked

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        return CategoryHolder(LayoutInflater.from(parent.context).inflate(R.layout.main_recycle_item_category_layout, parent, false))
    }

    override fun getItemCount() = data.size


    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        // 选中分类切换颜色
        val categoryColor =
            if(checked == position)
                R.color.main_gray_background_color
            else
                R.color.common_white
        holder.tvCategory.setBackgroundResource(categoryColor)
        holder.tvCategory.text = data[position]
        holder.tvCategory.setOnClickListener{
            notifyItemChanged(checked)
            checked = position
            notifyItemChanged(checked)
        }
    }


    class CategoryHolder(view: View) : RecyclerView.ViewHolder(view){
        val tvCategory:TextView = view.findViewById(R.id.tvCategory)
    }

}