package com.cxyz.message.ui.adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.cxyz.message.R;
import com.cxyz.message.ui.adapter.entity.Msg;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

import org.jetbrains.annotations.NotNull;

import java.util.List;


public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder>  {
    private List<Msg> mMsgList;

    static class ViewHolder extends RecyclerView.ViewHolder{

        LinearLayout leftLayout;
        LinearLayout rightLayout;
        TextView leftMsg;
        TextView rightMsg;
        QMUIRadiusImageView leftImg;
        QMUIRadiusImageView righrImg;

        public ViewHolder(View view){
            super(view);
            leftLayout = view.findViewById(R.id.left_layout);
            rightLayout = view.findViewById(R.id.right_layout);
            leftMsg = view.findViewById(R.id.left_msg);
            rightMsg = view.findViewById(R.id.right_msg);
            leftImg=view.findViewById(R.id.left_img);
            leftImg.setCircle(true);
            leftImg.setBorderWidth(0);
            righrImg=view.findViewById(R.id.right_img);
            righrImg.setCircle(true);
            righrImg.setBorderWidth(0);
        }
    }

    public MsgAdapter(List<Msg> msgList){
        mMsgList = msgList;
    }

    @Override
    @NotNull
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.message_msg_item,parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        Msg msg = mMsgList.get(position);
        if (msg.getType()==Msg.TYPE_RECEIVED){
            //如果是收到消息，则显示在左边，将右边布局隐藏
            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.rightLayout.setVisibility(View.GONE);
            holder.leftMsg.setText(msg.getContent());
            holder.leftImg.setImageBitmap(msg.getBitmap());

        }else if(msg.getType()==Msg.TYPE_SENT){
            holder.rightLayout.setVisibility(View.VISIBLE);
            holder.leftLayout.setVisibility(View.GONE);
            holder.rightMsg.setText(msg.getContent());
            holder.righrImg.setImageBitmap(msg.getBitmap());
        }
    }

    @Override
    public int getItemCount(){
        return mMsgList.size();
    }

}