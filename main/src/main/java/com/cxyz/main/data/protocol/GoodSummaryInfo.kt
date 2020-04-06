package com.cxyz.main.data.protocol

import java.math.BigDecimal

/**
 * 商铺的概要信息，用于在商铺页面展示各分类的商铺
 */
class GoodSummaryInfo {

    var id:Int? = null

    var name:String? = null

    var img:String? = null

    /**
     * 价格
     */
    var price:BigDecimal? = null
}