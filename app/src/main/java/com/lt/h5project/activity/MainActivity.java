package com.lt.h5project.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.lt.h5project.R;
import com.lt.h5project.bean.NetUrlBean;
import com.lt.h5project.constant.H5AggregationAddressConstant;
import com.lt.h5project.constant.H5PicAddressConstant;
import com.lt.h5project.constant.H5ReadAddressConstant;
import com.lt.h5project.constant.H5VideoAddressConstant;
import com.lt.h5project.net.GsonObjectCallback;
import com.lt.h5project.net.NetAddress;
import com.lt.h5project.net.OkHttp3Utils;
import com.lt.h5project.util.LogUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;

public class MainActivity extends AppCompatActivity {

    private static String TAG = MainActivity.class.getSimpleName() + ":";

    private Map<String, String> mParmas = new HashMap<>();

    public static List<NetUrlBean.DataEntity> mReadList = new ArrayList<>();
    public static List<NetUrlBean.DataEntity> mPicList = new ArrayList<>();
    public static List<NetUrlBean.DataEntity> mAggregationList = new ArrayList<>();
    ;
    public static List<NetUrlBean.DataEntity> mVideoList = new ArrayList<>();
    public static List<NetUrlBean.DataEntity> mCartoonList = new ArrayList<>();
    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getNetUrl();

        findViewById(R.id.tv_read).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, H5ReadActivity.class));
            }
        });

        findViewById(R.id.tv_pic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, H5PicActivity.class));
            }
        });

        findViewById(R.id.tv_video).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, H5VideoActivity.class));
            }
        });

        findViewById(R.id.tv_agg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, AggregationH5Activity.class));
            }
        });

        findViewById(R.id.tv_cartoon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, CartoonActivity.class));
            }
        });

        findViewById(R.id.tv_standby_application).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailsActivity.launch(MainActivity.this, new NetUrlBean.DataEntity(0, "http://t.alpha.channel.45xie.com/ad.html", "备用代码位", 0, 0));
            }
        });
    }

    private void getNetUrl() {
        OkHttp3Utils.doPost(NetAddress.BASE_URL, mParmas, new GsonObjectCallback<NetUrlBean>() {
            @Override
            public void onUi(NetUrlBean netUrlBean) {
                if (netUrlBean.ret.equals("succ")) {
                    LogUtils.d("网络数据");
                    List<NetUrlBean.DataEntity> data = netUrlBean.data;
//                    urlDeatail(data, 1, mReadList);
//                    urlDeatail(data, 2, mAggregationList);
//                    urlDeatail(data, 3, mPicList);
//                    urlDeatail(data, 4, mVideoList);


                    urlDeatail(data);
//                    getLocUrl();
                } else {
                    getLocUrl();
                }
            }


            @Override
            public void onFailedUi(Call call, IOException e) {
                getLocUrl();
            }
        });
    }

    private void getLocUrl() {
        LogUtils.d("本地数据");
        H5ReadAddressConstant h5ReadAddressConstant = new H5ReadAddressConstant();
        H5AggregationAddressConstant h5AggregationAddressConstant = new H5AggregationAddressConstant();
        H5PicAddressConstant h5PicAddressConstant = new H5PicAddressConstant();
        H5VideoAddressConstant h5VideoAddressConstant = new H5VideoAddressConstant();

        setReadLoc(h5ReadAddressConstant, mReadList);
        setAggLoc(h5AggregationAddressConstant, mAggregationList);
        setPicLoc(h5PicAddressConstant, mPicList);
        setVideoLoc(h5VideoAddressConstant, mVideoList);
    }

    private void setReadLoc(H5ReadAddressConstant h5ReadAddressConstant, List<NetUrlBean.DataEntity> List) {
        if (List != null && List.size() <= 0) {
            for (int i = 0; i < h5ReadAddressConstant.ReadList.size(); i++) {
                List.add(new NetUrlBean.DataEntity(i, h5ReadAddressConstant.ReadList.get(i).ChannelAddress, h5ReadAddressConstant.ReadList.get(i).ChannelName, 0, 0));
            }
        }
    }

    private void setAggLoc(H5AggregationAddressConstant h5AggregationAddressConstant, List<NetUrlBean.DataEntity> List) {
        if (List != null && List.size() <= 0) {
            for (int i = 0; i < h5AggregationAddressConstant.AggregationList.size(); i++) {
                List.add(new NetUrlBean.DataEntity(i, h5AggregationAddressConstant.AggregationList.get(i).ChannelAddress, h5AggregationAddressConstant.AggregationList.get(i).ChannelName, 0, 0));
            }
        }
    }

    private void setVideoLoc(H5VideoAddressConstant h5VideoAddressConstant, List<NetUrlBean.DataEntity> List) {
        if (List != null && List.size() <= 0) {
            for (int i = 0; i < h5VideoAddressConstant.VideoList.size(); i++) {
                List.add(new NetUrlBean.DataEntity(i, h5VideoAddressConstant.VideoList.get(i).ChannelAddress, h5VideoAddressConstant.VideoList.get(i).ChannelName, 0, 0));
            }
        }
    }

    private void setPicLoc(H5PicAddressConstant h5PicAddressConstant, List<NetUrlBean.DataEntity> List) {
        if (List != null && List.size() <= 0) {
            for (int i = 0; i < h5PicAddressConstant.PicList.size(); i++) {
                List.add(new NetUrlBean.DataEntity(i, h5PicAddressConstant.PicList.get(i).ChannelAddress, h5PicAddressConstant.PicList.get(i).ChannelName, 0, 0));
            }
        }
    }

    private void urlDeatail(List<NetUrlBean.DataEntity> data) {
        if (data != null && data.size() > 0) {
            for (int i = 0; i < data.size(); i++) {
                if (data.get(i).type == 1) {
//                    mReadList.add(data.get(i));
                    mReadList.add(new NetUrlBean.DataEntity(mReadList.size(), data.get(i).url, data.get(i).name, data.get(i).pv, data.get(i).uv));
                } else if (data.get(i).type == 2) {
                    mAggregationList.add(new NetUrlBean.DataEntity(mAggregationList.size(), data.get(i).url, data.get(i).name, data.get(i).pv, data.get(i).uv));
                } else if (data.get(i).type == 3) {
                    mPicList.add(new NetUrlBean.DataEntity(mPicList.size(), data.get(i).url, data.get(i).name, data.get(i).pv, data.get(i).uv));
                } else if (data.get(i).type == 4) {
                    mVideoList.add(new NetUrlBean.DataEntity(mVideoList.size(), data.get(i).url, data.get(i).name, data.get(i).pv, data.get(i).uv));
                } else if (data.get(i).type == 5) {
                    mCartoonList.add(new NetUrlBean.DataEntity(mCartoonList.size(), data.get(i).url, data.get(i).name, data.get(i).pv, data.get(i).uv));
                }
            }
            LogUtils.d(TAG + mReadList.size());
            LogUtils.d(TAG + mAggregationList.size());
            LogUtils.d(TAG + mPicList.size());
            LogUtils.d(TAG + mVideoList.size());
        }
    }
}
