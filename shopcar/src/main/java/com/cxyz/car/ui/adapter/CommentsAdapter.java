package com.cxyz.car.ui.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cxyz.car.R;
import com.cxyz.car.data.domain.CommentsItem;

import java.util.List;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.InnerHolder> {
    private Context context;
    private List<CommentsItem> commentsItemList;

    public CommentsAdapter(Context context, List<CommentsItem> commentsItemList) {
        this.context = context;
        this.commentsItemList = commentsItemList;
    }

    @NonNull
    @Override
    public CommentsAdapter.InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InnerHolder(LayoutInflater.from(context).inflate(R.layout.shopcar_recycle_item_comments,null));
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        Glide.with(holder.ivUserImage.getContext()).load(commentsItemList.get(position).getUserImage()).into(holder.ivUserImage);
        holder.tvUserName.setText(commentsItemList.get(position).getUserName());
        holder.tvDate.setText(commentsItemList.get(position).getDate());
        holder.tvStatus.setText(commentsItemList.get(position).getCommentsStatus());
        holder.tvDelete.setText(commentsItemList.get(position).getDelete());
        holder.tvDelete.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);//设置下划线
        holder.tvDelete.getPaint().setAntiAlias(true);//抗锯齿
        holder.tvContent.setText(commentsItemList.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return commentsItemList.size();
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        private ImageView ivUserImage;
        private TextView tvUserName;
        private TextView tvDate;
        private TextView tvStatus;
        private TextView tvDelete;
        private TextView tvContent;
        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            ivUserImage=itemView.findViewById(R.id.ivCommentsUserImage);
            tvUserName=itemView.findViewById(R.id.tvCommentsUserName);
            tvDate=itemView.findViewById(R.id.tvCommentsDate);
            tvStatus=itemView.findViewById(R.id.tvCommentsStatus);
            tvDelete=itemView.findViewById(R.id.tvCommentsDelete);
            tvContent=itemView.findViewById(R.id.tvCommentsContent);
        }
    }
}
