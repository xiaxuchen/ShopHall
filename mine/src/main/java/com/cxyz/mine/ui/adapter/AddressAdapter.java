package com.cxyz.mine.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cxyz.mine.R;
import com.cxyz.mine.ui.adapter.entity.Adress;

import java.util.List;

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.ViewHolder>{
    private List<Adress> addressList;

    //添加构造方法
    public AddressAdapter(List<Adress> addressList) {
        this.addressList = addressList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mine_recycle_item_adress_layout,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvAddressName;
        private TextView tvAddressPhone;
        private TextView tvAddressHometown;
        private TextView tvAddressHome;

        public ViewHolder(View itemView) {
            super(itemView);
            tvAddressName = itemView.findViewById(R.id.addressName);
            tvAddressPhone = itemView.findViewById(R.id.addressPhone);
            tvAddressHometown = itemView.findViewById(R.id.addressHometown);
            tvAddressHome = itemView.findViewById(R.id.addressHome);
        }
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        holder.tvAddressName.setText(addressList.get(position).getName());
        holder.tvAddressPhone.setText(addressList.get(position).getPhone());
        holder.tvAddressHometown.setText(addressList.get(position).getHometown());
        holder.tvAddressHome.setText(addressList.get(position).getHome());
    }

    @Override
    public int getItemCount() {
        return addressList.size();
    }
}
