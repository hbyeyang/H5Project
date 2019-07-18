package com.lt.h5project.adapter;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lt.h5project.R;
import com.lt.h5project.activity.DetailsActivity;
import com.lt.h5project.bean.AddressBean;
import com.lt.h5project.util.LogUtils;
import com.lt.h5project.view.UMExpandLayout;

import java.util.List;

/**
 * @author yeyang
 * @name H5project
 * @class name：com.lt.h5project.adapter
 * @class describe
 * @time 2019-07-16 11:37
 * @change
 * @chang time
 * @class describe
 */
public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyViewHolder> {
    private Context mContext;
    private List<AddressBean> mList;
    private View inflater;

    public RecyclerviewAdapter(Context context, List<AddressBean> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(mContext).inflate(R.layout.item_context, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(inflater);
//        myViewHolder.umeItem.collapse();
        return myViewHolder;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final AddressBean addressBean = mList.get(position);
        holder.llItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.umeItem.isExpand()){
                    holder.umeItem.collapse();
                }else {
                    holder.umeItem.expand();
                }
            }
        });
        holder.tvNum.setText(String.valueOf(addressBean.number));
        holder.tvDomai_name.setText(addressBean.domainame);
        holder.tvChannelName.setText(addressBean.ChannelName);
        holder.tvChannelAddress.setText(addressBean.ChannelAddress);
        holder.tvNei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtils.d("内跳");
                DetailsActivity.launch(mContext, addressBean);
            }
        });

        holder.tvWai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtils.d("外跳");
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                Uri content_url = Uri.parse(addressBean.ChannelAddress);
                intent.setData(content_url);
                mContext.startActivity(intent);
            }
        });

        holder.tvCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtils.d("复制");
                Message message = new Message();
                message.obj = addressBean;
                message.what = 1;
                mHandler.sendMessage(message);
            }
        });

        holder.llChannel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailsActivity.launch(mContext, addressBean);
            }
        });
    }

    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    try {
                        AddressBean addressBean = (AddressBean) msg.obj;
                        copy(mContext, addressBean.ChannelAddress);
                        Toast.makeText(mContext, "复制成功", Toast.LENGTH_SHORT).show();
                    }catch (Exception e){
                        LogUtils.d(e.toString().toString());
                    }
                    break;
                default:
                    super.handleMessage(msg);
            }
        }
    };

    /**
     * 复制内容到剪切板
     *
     * @param copyStr
     * @return
     */
    private boolean copy(Context context,String copyStr) {
        try {
            //获取剪贴板管理器
            ClipboardManager cm = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            // 创建普通字符型ClipData
            ClipData mClipData = ClipData.newPlainText("Label", copyStr);
            // 将ClipData内容放到系统剪贴板里。
            cm.setPrimaryClip(mClipData);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    //内部类，绑定控件
    class MyViewHolder extends RecyclerView.ViewHolder {
        UMExpandLayout umeItem;
        LinearLayout llItem;
        LinearLayout llChannel;
        TextView tvNum;
        TextView tvDomai_name;
        TextView tvChannelName;
        TextView tvChannelAddress;
        TextView tvNei;
        TextView tvWai;
        TextView tvCopy;

        public MyViewHolder(View itemView) {
            super(itemView);
            umeItem = (UMExpandLayout) itemView.findViewById(R.id.ume_item);
            llItem = (LinearLayout) itemView.findViewById(R.id.ll_item);
            llChannel = (LinearLayout) itemView.findViewById(R.id.ll_channel);
            tvNum = (TextView) itemView.findViewById(R.id.tv_num);
            tvDomai_name = (TextView) itemView.findViewById(R.id.tv_domai_name);
            tvChannelName = (TextView) itemView.findViewById(R.id.tv_channel_name);
            tvChannelAddress = (TextView) itemView.findViewById(R.id.tv_channel_address);
            tvNei = (TextView) itemView.findViewById(R.id.tv_nei);
            tvWai = (TextView) itemView.findViewById(R.id.tv_wai);
            tvCopy = (TextView) itemView.findViewById(R.id.tv_copy);
//            umeItem.collapse();
        }
    }
}