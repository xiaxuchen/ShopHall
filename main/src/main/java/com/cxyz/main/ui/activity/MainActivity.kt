package com.cxyz.main.ui.activity

import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.launcher.ARouter
import com.alibaba.android.arouter.facade.annotation.Route
import com.cxyz.main.R
import com.cxyz.main.ui.adapter.MainPagerAdapter
import com.cxyz.mvp.activity.BaseActivity
import com.cxyz.mvp.imodel.IBaseModel
import com.cxyz.mvp.ipresenter.IBasePresenter
import com.cxyz.mvp.iview.IBaseView
import kotlinx.android.synthetic.main.main_activity_main_layout.*
import org.jetbrains.anko.sdk25.coroutines.onCheckedChange

@Route(path = "/main/MainActivity")
class MainActivity : BaseActivity<IBasePresenter<IBaseModel,IBaseView>>() {

    private lateinit var mainFragment:Fragment

    private lateinit var shopCarFragment: Fragment

    private lateinit var mineFragment:Fragment

    private lateinit var messageFragment:Fragment

    override fun getContentView(): Any {
        return R.layout.main_activity_main_layout
    }

    override fun initView() {
        // 初始化fragments
        mainFragment = ARouter.getInstance().build("/shopcar/MainFragment").navigation() as Fragment
        shopCarFragment = ARouter.getInstance().build("/shopcar/ShopcarFragment").navigation() as Fragment
        mineFragment = ARouter.getInstance().build("/mine/MineFragment").navigation() as Fragment
        messageFragment = ARouter.getInstance().build("/message/ChatInfoFragment").navigation() as Fragment
        vpContent.adapter = MainPagerAdapter(supportFragmentManager, arrayOf(mainFragment,messageFragment,shopCarFragment,mineFragment))
    }

    override fun initData() {
    }

    override fun setEvent() {
        // 根据不同的tab点击切换Fragment
        rgMain.onCheckedChange { group, checkedId ->
            when(checkedId){
                R.id.rbMain -> {
                    vpContent.setCurrentItem(0,true)
                }
                R.id.rbMessage -> {
                    vpContent.setCurrentItem(1,true)
                }
                R.id.rbShopCar -> {
                    vpContent.setCurrentItem(2,true)
                }
                R.id.rbMine -> {
                    vpContent.setCurrentItem(3,true)
                }
            }
        }
    }

    override fun createIPresenter(): IBasePresenter<IBaseModel, IBaseView>? {
        return null
    }

}