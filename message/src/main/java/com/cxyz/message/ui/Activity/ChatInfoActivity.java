package com.cxyz.message.ui.Activity;

import android.graphics.Bitmap;
import android.view.View;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.message.R;
import com.cxyz.message.ui.adapter.RecyclerViewAdapter;
import com.cxyz.message.utils.RecyclerUtils;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.mvp.ipresenter.IBasePresenter;
import com.cxyz.utils.ToastUtil;
import com.cxyz.widget.HeaderBar;

import java.util.ArrayList;
import java.util.List;

@Route(path = "/message/ChatInfoActivity",group = "message")
public class ChatInfoActivity extends BaseActivity implements RecyclerViewAdapter.onSlidingViewClickListener{
    private RecyclerView recycler;              //在xml 中 RecyclerView 布局
    private RecyclerViewAdapter rvAdapter;      //message_item_recycler 布局的 适配器
    //设置数据
    private List<Bitmap> dataImage;    //头像（谁的头像）
    private List<String> dataTitle;     //标题（谁的消息）
    private List<String> datasContent;  //内容（消息内容）
    private List<String> datasTime;     //时间（消息时间）
    private HeaderBar hbChatinfotitle;
    @Override
    protected Object getContentView() {
        return R.layout.message_activity_chatinfo;
    }

    @Override
    public void initView() {
        recycler = (RecyclerView)findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        hbChatinfotitle=findViewById(R.id.hbChatinfotitle);
        datas();//插入数据
        //更新界面
        updateInterface();

    }

    @Override
    public void initData() {

    }

    @Override
    public void setEvent() {
        hbChatinfotitle.setBackClickListener(new HeaderBar.OnBackClickListener() {
            @Override
            public void onBackClick(View v) {
                getActivity().finish();
            }
        });

    }

    @Override
    protected IBasePresenter createIPresenter() {
        return null;
    }

    //通过 position 区分点击了哪个 item
    @Override
    public void onItemClick(View view, int position) {
        //在这里可以做出一些反应（跳转界面、弹出弹框之类）
        ToastUtil.showLong("你点了"+position);
    }

    //点击删除按钮时，根据传入的 position 调用 RecyclerAdapter 中的 removeData() 方法
    @Override
    public void onDeleteBtnCilck(View view, int position) {
        rvAdapter.removeData(position);
    }

    public void datas(){
        dataImage = new ArrayList<Bitmap>();    //头像（谁的头像）
        dataTitle = new ArrayList<String>();     //标题（谁的消息）
        datasContent = new ArrayList<String>();  //内容（消息内容）
        datasTime = new ArrayList<String>();     //时间（消息时间）
/*        dataImage.add(RecyclerUtils.toRoundBitmap(RecyclerUtils.bitmaps(R.mipmap.a10, this)));
        dataImage.add(RecyclerUtils.toRoundBitmap(RecyclerUtils.bitmaps(R.mipmap.a10, this)));
        dataImage.add(RecyclerUtils.toRoundBitmap(RecyclerUtils.bitmaps(R.mipmap.a10, this)));
        dataImage.add(RecyclerUtils.toRoundBitmap(RecyclerUtils.bitmaps(R.mipmap.a10, this)));
        dataImage.add(RecyclerUtils.toRoundBitmap(RecyclerUtils.bitmaps(R.mipmap.a10, this)));
        dataImage.add(RecyclerUtils.toRoundBitmap(RecyclerUtils.bitmaps(R.mipmap.a10, this)));
        dataImage.add(RecyclerUtils.toRoundBitmap(RecyclerUtils.bitmaps(R.mipmap.a10, this)));
        dataImage.add(RecyclerUtils.toRoundBitmap(RecyclerUtils.bitmaps(R.mipmap.a10, this)));
        dataImage.add(RecyclerUtils.toRoundBitmap(RecyclerUtils.bitmaps(R.mipmap.a10, this)));
        dataImage.add(RecyclerUtils.toRoundBitmap(RecyclerUtils.bitmaps(R.mipmap.a10, this)));
        dataImage.add(RecyclerUtils.toRoundBitmap(RecyclerUtils.bitmaps(R.mipmap.a10, this)));
        dataImage.add(RecyclerUtils.toRoundBitmap(RecyclerUtils.bitmaps(R.mipmap.a10, this)));*/
        dataImage.add(RecyclerUtils.bitmaps(R.mipmap.a10, this));
        dataImage.add(RecyclerUtils.bitmaps(R.mipmap.a10, this));
        dataImage.add(RecyclerUtils.bitmaps(R.mipmap.a10, this));
        dataImage.add(RecyclerUtils.bitmaps(R.mipmap.a10, this));
        dataImage.add(RecyclerUtils.bitmaps(R.mipmap.a10, this));
        dataImage.add(RecyclerUtils.bitmaps(R.mipmap.a10, this));
        dataImage.add(RecyclerUtils.bitmaps(R.mipmap.a10, this));
        dataImage.add(RecyclerUtils.bitmaps(R.mipmap.a10, this));
        dataImage.add(RecyclerUtils.bitmaps(R.mipmap.a10, this));
        dataImage.add(RecyclerUtils.bitmaps(R.mipmap.a10, this));
        dataImage.add(RecyclerUtils.bitmaps(R.mipmap.a10, this));
        dataImage.add(RecyclerUtils.bitmaps(R.mipmap.a10, this));
        dataTitle.add("Android开发交流群");
        dataTitle.add("R语言初级入门学习");
        dataTitle.add("刘亦菲");
        dataTitle.add("策划书交流群");
        dataTitle.add("15生态宜居学院学生群");
        dataTitle.add("湘环资助 （助学贷款）");
        dataTitle.add("湘环编程研讨会");
        dataTitle.add("丰风");
        dataTitle.add("阿娇");
        dataTitle.add("图书馆流通服务交流群");
        dataTitle.add("one3胡了");
        dataTitle.add("读者协会策划部");
        datasContent.add("广州_Even：[图片]");
        datasContent.add("轻舟飘飘：auto基本不准");
        datasContent.add("不会的");
        datasContent.add("残留的余温。：分享[熊猫直播]");
        datasContent.add("刘老师：[文件]2018年6月全国大学……");
        datasContent.add("17级园林");
        datasContent.add("黄晓明：20k不到");
        datasContent.add("[文件]编程之美");
        datasContent.add("i5的处理器，比较稳定，蛮好的");
        datasContent.add("寥寥：好的，谢谢老师");
        datasContent.add("易天：阿龙还在面试呢");
        datasContent.add("策划部陈若依、：请大家把备注改好");
        datasTime.add("16:24");
        datasTime.add("14:37");
        datasTime.add("10:58");
        datasTime.add("昨天");
        datasTime.add("昨天");
        datasTime.add("昨天");
        datasTime.add("星期三");
        datasTime.add("星期三");
        datasTime.add("星期二");
        datasTime.add("星期二");
        datasTime.add("星期二");
        datasTime.add("星期一");
    }

    public void updateInterface(){
        if (rvAdapter == null) {
            //实例化 RecyclerViewAdapter 并设置数据
            rvAdapter = new RecyclerViewAdapter(this,
                    dataImage, dataTitle, datasContent, datasTime);
            //将适配的内容放入 mRecyclerView
            recycler.setAdapter(rvAdapter);
            //控制Item增删的动画，需要通过ItemAnimator  DefaultItemAnimator -- 实现自定义动画
            recycler.setItemAnimator(new DefaultItemAnimator());
        }else {
            //强调通过 getView() 刷新每个Item的内容
            rvAdapter.notifyDataSetChanged();
        }
        //设置滑动监听器 （侧滑）
        rvAdapter.setOnSlidListener(this);
    }

}
