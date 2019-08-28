package com.lt.h5project.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.lt.h5project.R;
import com.lt.h5project.bean.NetUrlBean;
import com.lt.h5project.constant.H5AggregationAddressConstant;
import com.lt.h5project.constant.H5CookBookAddressConstant;
import com.lt.h5project.constant.H5PicAddressConstant;
import com.lt.h5project.constant.H5ReadAddressConstant;
import com.lt.h5project.constant.H5VideoAddressConstant;
import com.lt.h5project.net.GsonObjectCallback;
import com.lt.h5project.net.NetAddress;
import com.lt.h5project.net.OkHttp3Utils;
import com.lt.h5project.util.LogUtils;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;

public class MainActivity extends AppCompatActivity {

    private static String TAG = MainActivity.class.getSimpleName() + ":";

    private Map<String, String> mParmas = new HashMap<>();

    private int mH5Count;//总链接数
    private int mReadCount;//小说链接
    private int mPicCount;//美图链接
    private int mVideoCount;//视频链接
    private int mAggCount;//聚合链接
    private int mCartoonCount;//漫画链接
    private int mCookBookCount;//菜谱链接

    private int mH5CountUv;//总链接数
    private int mReadCountUv;//小说链接
    private int mPicCountUv;//美图链接
    private int mVideoCountUv;//视频链接
    private int mAggCountUv;//聚合链接
    private int mCartoonCountUv;//漫画链接
    private int mCookBookCountUv;//菜谱链接

    private int mH5CountPv;//总链接数
    private int mReadCountPv;//小说链接
    private int mPicCountPv;//美图链接
    private int mVideoCountPv;//视频链接
    private int mAggCountPv;//聚合链接
    private int mCartoonCountPv;//漫画链接
    private int mCookBookCountPv;//菜谱链接


    public static List<NetUrlBean.DataEntity> mReadList = new ArrayList<>();
    public static List<NetUrlBean.DataEntity> mPicList = new ArrayList<>();
    public static List<NetUrlBean.DataEntity> mAggregationList = new ArrayList<>();
    public static List<NetUrlBean.DataEntity> mVideoList = new ArrayList<>();
    public static List<NetUrlBean.DataEntity> mCartoonList = new ArrayList<>();
    public static List<NetUrlBean.DataEntity> mCookBookList = new ArrayList<>();
    private TextView mTvH5Count;
    private TextView mTvRead;
    private TextView mTvPic;
    private TextView mTvVideo;
    private TextView mTvAgg;
    private TextView mTvCartoon;
    private TextView mTvCookbook;
    private TextView mTvStandbyApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvH5Count = findViewById(R.id.tv_h5_count);

        if (mReadList.size() == 0 && mPicList.size() == 0) {
            getNetUrl();
        }

        mTvRead = findViewById(R.id.tv_read);
        mTvPic = findViewById(R.id.tv_pic);
        mTvVideo = findViewById(R.id.tv_video);
        mTvAgg = findViewById(R.id.tv_agg);
        mTvCartoon = findViewById(R.id.tv_cartoon);
        mTvCookbook = findViewById(R.id.tv_cookbook);
        mTvStandbyApplication = findViewById(R.id.tv_standby_application);

        mTvRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, H5ReadActivity.class));
            }
        });

        mTvPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, H5PicActivity.class));
            }
        });

        mTvVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, H5VideoActivity.class));
            }
        });
        mTvAgg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, AggregationH5Activity.class));
            }
        });
        mTvCartoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, CartoonActivity.class));
            }
        });
        mTvCookbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, CookBookActivity.class));
            }
        });

        mTvStandbyApplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"点击",Toast.LENGTH_SHORT).show();
                DetailsActivity.launch(MainActivity.this, new NetUrlBean.DataEntity(0, "http://t.alpha.channel.45xie.com/ad.html", "备用代码位", 0, 0));
//                DetailsActivity.launch(MainActivity.this, new NetUrlBean.DataEntity(0, "https://m.xi5jie.com/install/land?channelCode=letu", "备用代码位", 0, 0));
//                DetailsActivity.launch(MainActivity.this, new NetUrlBean.DataEntity(0, "http://a.app.qq.com/o/simple.jsp?pkgname=com.xszn.ime&ckey=CK1429286954552", "备用代码位", 0, 0));
            }
        });
//        findViewById(R.id.tv_read).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MainActivity.this.startActivity(new Intent(MainActivity.this, H5ReadActivity.class));
//            }
//        });
//
//        findViewById(R.id.tv_pic).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MainActivity.this.startActivity(new Intent(MainActivity.this, H5PicActivity.class));
//            }
//        });

//        findViewById(R.id.tv_video).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MainActivity.this.startActivity(new Intent(MainActivity.this, H5VideoActivity.class));
//            }
//        });

//        findViewById(R.id.tv_agg).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MainActivity.this.startActivity(new Intent(MainActivity.this, AggregationH5Activity.class));
//            }
//        });

//        findViewById(R.id.tv_cartoon).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MainActivity.this.startActivity(new Intent(MainActivity.this, CartoonActivity.class));
//            }
//        });

//        findViewById(R.id.tv_cookbook).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MainActivity.this.startActivity(new Intent(MainActivity.this, CookBookActivity.class));
//            }
//        });

//        findViewById(R.id.tv_standby_application).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DetailsActivity.launch(MainActivity.this, new NetUrlBean.DataEntity(0, "http://t.alpha.channel.45xie.com/ad.html", "备用代码位", 0, 0));
//            }
//        });
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
                    //排序
                    Collections.sort(data);
                    //倒序
                    Collections.reverse(data);
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
        H5CookBookAddressConstant h5CookBookAddressConstant = new H5CookBookAddressConstant();

        setReadLoc(h5ReadAddressConstant, mReadList);
        setAggLoc(h5AggregationAddressConstant, mAggregationList);
        setPicLoc(h5PicAddressConstant, mPicList);
        setVideoLoc(h5VideoAddressConstant, mVideoList);
        setCookBookLoc(h5CookBookAddressConstant, mCookBookList);
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

    private void setCookBookLoc(H5CookBookAddressConstant h5CookBookAddressConstant, List<NetUrlBean.DataEntity> List) {
        if (List != null && List.size() <= 0) {
            for (int i = 0; i < h5CookBookAddressConstant.CookBookList.size(); i++) {
                List.add(new NetUrlBean.DataEntity(i, h5CookBookAddressConstant.CookBookList.get(i).ChannelAddress, h5CookBookAddressConstant.CookBookList.get(i).ChannelName, 0, 0));
            }
        }
    }

    private void urlDeatail(List<NetUrlBean.DataEntity> data) {
        if (data != null && data.size() > 0) {
            for (int i = 0; i < data.size(); i++) {
                if (data.get(i).type == 1) {
//                    mReadList.add(data.get(i));
                    mReadList.add(new NetUrlBean.DataEntity(mReadList.size(), data.get(i).url, data.get(i).name, data.get(i).pv, data.get(i).uv));
                    if (data.get(i).uv >= 100) {
                        mReadCount++;
                        mReadCountUv += data.get(i).uv;
                        mReadCountPv += data.get(i).pv;
                    }
                } else if (data.get(i).type == 2) {
                    mAggregationList.add(new NetUrlBean.DataEntity(mAggregationList.size(), data.get(i).url, data.get(i).name, data.get(i).pv, data.get(i).uv));
                    if (data.get(i).uv >= 100) {
                        mAggCount++;
                        mAggCountUv += data.get(i).uv;
                        mAggCountPv += data.get(i).pv;
                    }
                } else if (data.get(i).type == 3) {
                    mPicList.add(new NetUrlBean.DataEntity(mPicList.size(), data.get(i).url, data.get(i).name, data.get(i).pv, data.get(i).uv));
                    if (data.get(i).uv >= 100) {
                        mPicCount++;
                        mPicCountUv += data.get(i).uv;
                        mPicCountPv += data.get(i).pv;
                    }
                } else if (data.get(i).type == 4) {
                    mVideoList.add(new NetUrlBean.DataEntity(mVideoList.size(), data.get(i).url, data.get(i).name, data.get(i).pv, data.get(i).uv));
                    if (data.get(i).uv >= 100) {
                        mVideoCount++;
                        mVideoCountUv += data.get(i).uv;
                        mVideoCountPv += data.get(i).pv;
                    }
                } else if (data.get(i).type == 5) {
                    mCartoonList.add(new NetUrlBean.DataEntity(mCartoonList.size(), data.get(i).url, data.get(i).name, data.get(i).pv, data.get(i).uv));
                    if (data.get(i).uv >= 100) {
                        mCartoonCount++;
                        mCartoonCountUv += data.get(i).uv;
                        mCartoonCountPv += data.get(i).pv;
                    }
                } else if (data.get(i).type == 6) {
                    mCookBookList.add(new NetUrlBean.DataEntity(mCookBookList.size(), data.get(i).url, data.get(i).name, data.get(i).pv, data.get(i).uv));
                    if (data.get(i).uv >= 100) {
                        mCookBookCount++;
                        mCookBookCountUv += data.get(i).uv;
                        mCookBookCountPv += data.get(i).pv;
                    }
                }
            }
            for (int i = 0; i < data.size(); i++) {
                if (data.get(i).uv >= 100) {
                    mH5Count++;
                }
            }
            LogUtils.d(TAG + mReadList.size());
            LogUtils.d(TAG + mAggregationList.size());
            LogUtils.d(TAG + mPicList.size());
            LogUtils.d(TAG + mVideoList.size());
            LogUtils.d(TAG + mCookBookList.size());
            LogUtils.d(TAG + mH5Count);
            mH5CountUv = mReadCountUv + mPicCountUv + mVideoCountUv + mAggCountUv + mCartoonCountUv + mCookBookCountUv;
            mH5CountPv = mReadCountPv + mPicCountPv + mVideoCountPv + mAggCountPv + mCartoonCountPv + mCookBookCountPv;
            H5Text(mTvH5Count, "H5链接数为(大于100UV):", mH5Count, mH5CountUv, mH5CountPv);
            H5Text(mTvRead, "H5小说:", mReadCount, mReadCountUv, mReadCountPv);
            H5Text(mTvPic, "H5美图:", mPicCount, mPicCountUv, mPicCountPv);
            H5Text(mTvVideo, "H5视频:", mVideoCount, mVideoCountUv, mVideoCountPv);
            H5Text(mTvAgg, "H5聚合:", mAggCount, mAggCountUv, mAggCountPv);
            H5Text(mTvCartoon, "H5漫画:", mCartoonCount, mCartoonCountUv, mCartoonCountPv);
            H5Text(mTvCookbook, "H5菜谱:", mCookBookCount, mCookBookCountUv, mCookBookCountPv);
        }
    }

    private void H5Text(TextView textView, String name, int h5Count, int h5CountUv, int h5CountPv) {
        if (h5CountUv != 0) {
//            textView.setText(name + h5Count + "--uv:" + readableFileSize(h5CountUv) + "--pv:" + readableFileSize(h5CountPv) + "--u/p:" + h5CountPv / h5CountUv);
            textView.setText(name + h5Count + "--uv:" + readableFileSize(h5CountUv) + "--pv:" + readableFileSize(h5CountPv) + "--u/p:" + xiaoshu(h5CountPv, h5CountUv));
        } else {
            textView.setText(name + h5Count + "--uv:" + readableFileSize(h5CountUv) + "--pv:" + readableFileSize(h5CountPv));
        }
    }

    private String readableFileSize(double size) {
        if (size < 1000) {
            return size + "";
        } else {
            double v = size / 1000;
            LogUtils.d(TAG + v);
            return new DecimalFormat("0.0").format(v) + "k";
        }
    }

    private String xiaoshu(int h5CountPv, double h5CountUv) {
        return new DecimalFormat("0.0").format(h5CountPv / h5CountUv * 1.0) + "";
    }
}
