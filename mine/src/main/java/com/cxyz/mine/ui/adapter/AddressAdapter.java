package com.cxyz.mine.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cxyz.mine.R;
import com.cxyz.mine.ui.activity.ChangAddressActivity;
import com.cxyz.mine.ui.adapter.entity.Adress;
import com.cxyz.utils.ToastUtil;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;

import java.util.List;

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.ViewHolder>{
    public static List<Adress> addressList;
    private Context context;
    public static String addressName;
    public static String addressPhone;
    public static String addressHometown;
    public static String addressHome;
    //添加构造方法
    public AddressAdapter(List<Adress> addressList) {
        this.addressList = addressList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mine_recycle_item_adress_layout,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return  holder;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvAddressName;
        private TextView tvAddressPhone;
        private TextView tvAddressHometown;
        private TextView tvAddressHome;
        private TextView addressChang;
        private TextView btnAddAddress;
        private TextView tvDeleteAddress;

        public ViewHolder(View itemView) {
            super(itemView);
            tvAddressName = itemView.findViewById(R.id.addressName);
            tvAddressPhone = itemView.findViewById(R.id.addressPhone);
            tvAddressHometown = itemView.findViewById(R.id.addressHometown);
            tvAddressHome = itemView.findViewById(R.id.addressHome);
            addressChang = itemView.findViewById(R.id.addressChang);
            tvDeleteAddress = itemView.findViewById(R.id.tvDeleteAddress);
            addressChang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addressName = tvAddressName.getText().toString();
                    addressPhone = tvAddressPhone.getText().toString();
                    addressHometown = tvAddressHometown.getText().toString();
                    addressHome = tvAddressHome.getText().toString();
                    Intent intent = new Intent(v.getContext(), ChangAddressActivity.class);
                    v.getContext().startActivity(intent);
                }
            });


        }
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        layoutParams.height = LinearLayout.LayoutParams.WRAP_CONTENT;
        holder.tvAddressName.setText(addressList.get(position).getName());
        holder.tvAddressPhone.setText(addressList.get(position).getPhone());
        holder.tvAddressHometown.setText(addressList.get(position).getHometown());
        holder.tvAddressHome.setText(addressList.get(position).getHome());
        holder.tvDeleteAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new QMUIDialog.MessageDialogBuilder(v.getContext())
                        .setMessage("确认删除吗？")
                        .setTitle("提示")
                        .addAction("取消", new QMUIDialogAction.ActionListener() {
                            @Override
                            public void onClick(QMUIDialog dialog, int index) {
                                dialog.dismiss();
                            }
                        })
                        .addAction("确定", new QMUIDialogAction.ActionListener() {
                            @Override
                            public void onClick(QMUIDialog dialog, int index) {
                                dialog.dismiss();
                                ToastUtil.showShort("删除成功");
                            }
                        })
                        .show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return addressList.size();
    }
}
