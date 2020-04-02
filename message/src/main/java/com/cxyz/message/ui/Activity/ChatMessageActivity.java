package com.cxyz.message.ui.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.message.R;
import com.cxyz.message.ui.adapter.MsgAdapter;
import com.cxyz.message.ui.adapter.entity.Msg;
import com.cxyz.message.utils.RecyclerUtils;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.mvp.ipresenter.IBasePresenter;
import com.cxyz.utils.ColorsUtil;
import com.cxyz.widget.HeaderBar;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;

import java.util.ArrayList;
import java.util.List;
@Route(path = "/message/ChatMessageActivity",group = "message")
public class ChatMessageActivity extends BaseActivity {
    private List<Msg> msgList = new ArrayList<>();
    private EditText inputText;
    private QMUIRoundButton btSend;
    private RecyclerView rvMsg;
    private MsgAdapter adapter;
    private HeaderBar hbChatmesTitle;
    @Override
    protected Object getContentView() {
        return R.layout.message_activity_main;
    }

    @Override
    public void initView() {
        initMsgs();
        hbChatmesTitle=findViewById(R.id.hbchatmestitle);
        hbChatmesTitle.setTitle("李明");
        hbChatmesTitle.setMore(R.mipmap.message_chatmesg_gengduo,"店铺");
        hbChatmesTitle.setBackColor(ColorsUtil.BLUE_LIGHT);
        inputText = (EditText)findViewById(R.id.input_txet);
        btSend = (QMUIRoundButton) findViewById(R.id.send);
        btSend.setBackgroundColor(ColorsUtil.ORANGE);
        rvMsg = (RecyclerView)findViewById(R.id.msg_recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvMsg.setLayoutManager(layoutManager);
        adapter = new MsgAdapter(msgList);
        rvMsg.setAdapter(adapter);

    }

    @Override
    public void initData() {

    }

    @Override
    public void setEvent() {
        hbChatmesTitle.setBackClickListener(new HeaderBar.OnBackClickListener() {
            @Override
            public void onBackClick(View v) {
                getActivity().finish();
            }
        });
        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();

                if(!"".equals(content)){
                    Msg msg = new Msg(content,Msg.TYPE_SENT, RecyclerUtils.bitmaps(R.mipmap.a10, getApplicationContext()));
                    msgList.add(msg);
                    //当有新消息，刷新RecyclerVeiw的显示
                    adapter.notifyItemInserted(msgList.size() - 1);
                    //将RecyclerView定位到最后一行
                    rvMsg.scrollToPosition(msgList.size() - 1);
                    //清空输入框内容
                    inputText.setText("");

                }
            }
        });
    }

    @Override
    protected IBasePresenter createIPresenter() {
        return null;
    }
    private void initMsgs(){
        Msg msg1 = new Msg("你好哇，李银河",Msg.TYPE_RECEIVED,RecyclerUtils.bitmaps(R.mipmap.a10, this));
        msgList.add(msg1);
        Msg msg2 = new Msg("Hi,我是张三",Msg.TYPE_SENT,RecyclerUtils.bitmaps(R.mipmap.chatinfo_logistics, this));
        msgList.add(msg2);
        Msg msg3 = new Msg("当我跨过沉沦到一切，向着永恒开战的时候，你是我的军旗，长相思兮长相忆，短相思兮无穷极，一天一点爱恋，一夜一点思念",
                Msg.TYPE_RECEIVED,RecyclerUtils.bitmaps(R.mipmap.a10, this));
        msgList.add(msg3);
        Msg msg4 = new Msg("命里有时终须有，命里无时莫强求",Msg.TYPE_SENT,RecyclerUtils.bitmaps(R.mipmap.chatinfo_logistics, this));
        msgList.add(msg4);
    }
}
