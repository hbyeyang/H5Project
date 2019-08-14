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
import com.lt.h5project.bean.NetUrlBean;
import com.lt.h5project.util.LogUtils;
import com.lt.h5project.view.UMExpandLayout;

import java.text.DecimalFormat;
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
    private List<NetUrlBean.DataEntity> mList;
    private View inflater;

    public RecyclerviewAdapter(Context context, List<NetUrlBean.DataEntity> list) {
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
        final NetUrlBean.DataEntity dataEntity = mList.get(position);
        LogUtils.d(dataEntity.number + "..." + dataEntity.name + "..." + dataEntity.url);
        holder.llItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.umeItem.isExpand()) {
                    LogUtils.d("isExpand:" + holder.umeItem.isExpand());
                    holder.umeItem.collapse();
                    holder.tvItem.setText("展开");
                } else {
                    LogUtils.d("isExpand:" + holder.umeItem.isExpand());
                    holder.umeItem.expand();
                    holder.tvItem.setText("缩起");
                }
            }
        });
        holder.tvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.umeItem.isExpand()) {
                    LogUtils.d("isExpand:" + holder.umeItem.isExpand());
                    holder.umeItem.collapse();
                    holder.tvItem.setText("展开");
                } else {
                    LogUtils.d("isExpand:" + holder.umeItem.isExpand());
                    holder.umeItem.expand();
                    holder.tvItem.setText("缩起");
                }
            }
        });
        holder.tvNum.setText(String.valueOf(dataEntity.number));
//        holder.tvDomai_name.setText(dataEntity.domainame);
        holder.tvChannelName.setText(dataEntity.name);
        holder.tvChannelAddress.setText(dataEntity.url);
//        holder.tvUv.setText(String.valueOf(dataEntity.uv));
//        holder.tvPv.setText(String.valueOf(dataEntity.pv));
        holder.tvChannelNameDetails.setText(dataEntity.name);
        holder.tvUv.setText(addComma(String.valueOf(dataEntity.uv)));
        holder.tvPv.setText(addComma(String.valueOf(dataEntity.pv)));
        holder.tvNei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtils.d("内跳");
                DetailsActivity.launch(mContext, dataEntity);
            }
        });

        holder.tvWai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtils.d("外跳");
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
//                Uri content_url = Uri.parse(dataEntity.url);
                Uri content_url = Uri.parse(loadUrl(dataEntity.url));
                intent.setData(content_url);
                mContext.startActivity(intent);
            }
        });

        holder.tvCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtils.d("复制");
                Message message = new Message();
                message.obj = dataEntity;
                message.what = 1;
                mHandler.sendMessage(message);
            }
        });

        holder.llChannel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailsActivity.launch(mContext, dataEntity);
            }
        });
    }

    private String loadUrl(String url) {
        if (!url.startsWith("http")) {
            url = "http://" + url;
            return url;
        }
        return url;
    }

    /**
     * 将每三个数字加上逗号处理（通常使用金额方面的编辑）
     *
     * @param str 需要处理的字符串
     * @return 处理完之后的字符串
     */
    private String addComma(String str) {
        DecimalFormat decimalFormat = new DecimalFormat(",###");
        return decimalFormat.format(Double.parseDouble(str));
    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    try {
                        NetUrlBean.DataEntity dataEntity = (NetUrlBean.DataEntity) msg.obj;
                        copy(mContext, loadUrl(dataEntity.url));
                        Toast.makeText(mContext, "复制成功", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
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
    private boolean copy(Context context, String copyStr) {
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
        TextView tvChannelNameDetails;
        TextView tvChannelAddress;
        TextView tvNei;
        TextView tvWai;
        TextView tvCopy;
        TextView tvUv;
        TextView tvPv;
        TextView tvItem;

        public MyViewHolder(View itemView) {
            super(itemView);
            umeItem = (UMExpandLayout) itemView.findViewById(R.id.ume_item);
            llItem = (LinearLayout) itemView.findViewById(R.id.ll_item);
            llChannel = (LinearLayout) itemView.findViewById(R.id.ll_channel);
            tvNum = (TextView) itemView.findViewById(R.id.tv_num);
            tvDomai_name = (TextView) itemView.findViewById(R.id.tv_domai_name);
            tvChannelName = (TextView) itemView.findViewById(R.id.tv_channel_name);
            tvChannelNameDetails = (TextView) itemView.findViewById(R.id.tv_channel_name_details);
            tvChannelAddress = (TextView) itemView.findViewById(R.id.tv_channel_address);
            tvNei = (TextView) itemView.findViewById(R.id.tv_nei);
            tvWai = (TextView) itemView.findViewById(R.id.tv_wai);
            tvCopy = (TextView) itemView.findViewById(R.id.tv_copy);
            tvUv = (TextView) itemView.findViewById(R.id.tv_uv);
            tvPv = (TextView) itemView.findViewById(R.id.tv_pv);
            tvItem = (TextView) itemView.findViewById(R.id.tv_item);
//            umeItem.collapse();
        }
    }
}