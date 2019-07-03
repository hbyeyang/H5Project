package com.lt.h5project;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * @author yeyang
 * @name H5project
 * @class name：com.lt.h5project
 * @class describe
 * @time 2019-06-18 11:05
 * @change
 * @chang time
 * @class describe
 */
class PicAdapter extends RecyclerView.Adapter<PicAdapter.MyViewHolder> {
    private Context mContext;
    private List<AddressBean> mList;
    private View inflater;

    public PicAdapter(Context context, List<AddressBean> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(mContext).inflate(R.layout.item_context, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(inflater);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final AddressBean addressBean = mList.get(position);
        holder.tvNum.setText(String.valueOf(addressBean.number));
        holder.tvDomai_name.setText(addressBean.domainame);
        holder.tvChannelName.setText(addressBean.ChannelName);
        holder.tvChannelAddress.setText(addressBean.ChannelAddress);
        holder.tvNei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailsActivity.launch(mContext, addressBean);
            }
        });

        holder.tvWai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                Uri content_url = Uri.parse(addressBean.ChannelAddress);
                intent.setData(content_url);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    //内部类，绑定控件
    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvNum;
        TextView tvDomai_name;
        TextView tvChannelName;
        TextView tvChannelAddress;
        TextView tvNei;
        TextView tvWai;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvNum = (TextView) itemView.findViewById(R.id.tv_num);
            tvDomai_name = (TextView) itemView.findViewById(R.id.tv_domai_name);
            tvChannelName = (TextView) itemView.findViewById(R.id.tv_channel_name);
            tvChannelAddress = (TextView) itemView.findViewById(R.id.tv_channel_address);
            tvNei = (TextView) itemView.findViewById(R.id.tv_nei);
            tvWai = (TextView) itemView.findViewById(R.id.tv_wai);
        }
    }
}
