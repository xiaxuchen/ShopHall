package com.cxyz.message.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.message.R;
import com.cxyz.message.adapter.MsgAdapter;
import com.cxyz.message.bean.Msg;
import com.cxyz.utils.ColorsUtil;
import com.cxyz.widget.HeaderBar;

import java.util.ArrayList;
import java.util.List;
@Route(path = "/message/ChatMessageActivity")
public class ChatMessageActivity extends AppCompatActivity {
    private List<Msg> msgList = new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView msgRecyclerView;
    private MsgAdapter adapter;
    private HeaderBar hbchatmestitle;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMsgs();
        hbchatmestitle=findViewById(R.id.hbchatmestitle);
        hbchatmestitle.setTitle("李明");
        hbchatmestitle.setBackColor(ColorsUtil.BLUE_LIGHT);
        inputText = (EditText)findViewById(R.id.input_txet);
        send = (Button) findViewById(R.id.send);
        msgRecyclerView = (RecyclerView)findViewById(R.id.msg_recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(layoutManager);
        adapter = new MsgAdapter(msgList);
        msgRecyclerView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();

                if(!"".equals(content)){
                    Msg msg = new Msg(content,Msg.TYPE_SENT);
                    msgList.add(msg);
                    //当有新消息，刷新RecyclerVeiw的显示
                    adapter.notifyItemInserted(msgList.size() - 1);
                    //将RecyclerView定位到最后一行
                    msgRecyclerView.scrollToPosition(msgList.size() - 1);
                    //清空输入框内容
                    inputText.setText("");

                }
            }
        });
    }
    private void initMsgs(){
        Msg msg1 = new Msg("你好哇，李银河",Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("Hi",Msg.TYPE_SENT);
        msgList.add(msg2);
        Msg msg3 = new Msg("当我跨过沉沦到一切，向着永恒开战的时候，你是我的军旗",
                Msg.TYPE_RECEIVED);
        msgList.add(msg3);
    }

}
