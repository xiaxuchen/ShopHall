package com.cxyz.main.ext

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent

/**
 * 初始化RecycleView的holder的布局文件，解决item不能填满父容器的问题
 */
inline fun inflateHolderView (resId:Int,parent:ViewGroup,attachToRoot:Boolean = false):View {
    return LayoutInflater.from(parent.context).inflate(resId,parent,attachToRoot)
}