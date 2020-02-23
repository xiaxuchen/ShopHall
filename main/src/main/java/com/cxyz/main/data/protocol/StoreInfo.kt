package com.cxyz.main.data.protocol;

public class StoreInfo {

    /**
     * 店铺id
     */
    var id:String? = null

    /**
     * 店铺名称
     */
    var name:String? = null

    /**
     * 店铺图片
     */
    var img: String? = null

    /**
     * 电话
     */
    var phone:String? = null

    /**
     * 老板名称
     */
    var bossName:String? = null

    /**
     * 店铺地址
     */
    var address:String? = null

    /**
     * 商铺资质标签，如百年老店图标，通过数值指定显示
     */
    var tags: List<Int>? = null

    /**
     * 主营商铺
     */
    var mainGood: String? = null

    /**
     * 公告
     */
    var notice:String? = null;

    /**
     * 是否已收藏
     */
    var isCollect: Boolean? = null

    override fun toString(): String {
        return "StoreInfo(id=$id, name=$name, phone=$phone, bossName=$bossName, address=$address, tags=$tags, mainGood=$mainGood, notice=$notice, isCollect=$isCollect)"
    }


}
