package com.lt.h5project.activity;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.lt.h5project.R;
import com.lt.h5project.bean.NetUrlBean;
import com.lt.h5project.builder.Cat;
import com.lt.h5project.builder.dogbuilder.Dog;
import com.lt.h5project.builder.phonebuilder.Builder;
import com.lt.h5project.builder.phonebuilder.Director;
import com.lt.h5project.builder.phonebuilder.Phone;
import com.lt.h5project.builder.phonebuilder.PhoneBuilder;
import com.lt.h5project.constant.H5Constant;
import com.lt.h5project.factory.Animal;
import com.lt.h5project.factory.CatFactory;
import com.lt.h5project.factory.DogFactory;
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
    private int mPicContextCount;//图文链接
    private int mBeautyCount;//美妆链接
    private int mCarCount;//汽车链接
    private int mGoldCount;//砸金蛋链接
    private int mNewPicCount;//新美图链接
    private int mCatCount;//养猫链接
    private int mLifeCount;//生活链接

    private int mH5CountUv;//总链接数
    private int mReadCountUv;//小说链接
    private int mPicCountUv;//美图链接
    private int mVideoCountUv;//视频链接
    private int mAggCountUv;//聚合链接
    private int mCartoonCountUv;//漫画链接
    private int mCookBookCountUv;//菜谱链接
    private int mPicContextCountUv;//图文链接
    private int mBeautyCountUv;//美妆链接
    private int mCarCountUv;//汽车链接
    private int mGoldCountUv;//砸金蛋链接
    private int mNewPicCountUv;//新美图链接
    private int mCatCountUv;//养猫链接
    private int mLifeCountUv;//生活链接

    private int mH5CountPv;//总链接数
    private int mReadCountPv;//小说链接
    private int mPicCountPv;//美图链接
    private int mVideoCountPv;//视频链接
    private int mAggCountPv;//聚合链接
    private int mCartoonCountPv;//漫画链接
    private int mCookBookCountPv;//菜谱链接
    private int mPicContextCountPv;//图文链接
    private int mBeautyCountPv;//美妆链接
    private int mCarCountPv;//汽车链接
    private int mGoldCountPv;//砸金蛋链接
    private int mNewPicCountPv;//新美图链接
    private int mCatCountPv;//养猫链接
    private int mLifeCountPv;//生活链接


    public static List<NetUrlBean.DataEntity> mReadList = new ArrayList<>();
    public static List<NetUrlBean.DataEntity> mPicList = new ArrayList<>();
    public static List<NetUrlBean.DataEntity> mAggregationList = new ArrayList<>();
    public static List<NetUrlBean.DataEntity> mVideoList = new ArrayList<>();
    public static List<NetUrlBean.DataEntity> mCartoonList = new ArrayList<>();
    public static List<NetUrlBean.DataEntity> mCookBookList = new ArrayList<>();
    public static List<NetUrlBean.DataEntity> mPicContextList = new ArrayList<>();
    public static List<NetUrlBean.DataEntity> mBeautyList = new ArrayList<>();
    public static List<NetUrlBean.DataEntity> mCarList = new ArrayList<>();
    public static List<NetUrlBean.DataEntity> mGoldList = new ArrayList<>();
    public static List<NetUrlBean.DataEntity> mNewPicList = new ArrayList<>();
    public static List<NetUrlBean.DataEntity> mCatList = new ArrayList<>();
    public static List<NetUrlBean.DataEntity> mLifeList = new ArrayList<>();
    private TextView mTvH5Count;
    private TextView mTvRead;
    private TextView mTvPic;
    private TextView mTvVideo;
    private TextView mTvAgg;
    private TextView mTvCartoon;
    private TextView mTvCookbook;
    private TextView mTvPicContext;
    private TextView mTvBeauty;
    private TextView mTvCar;
    private TextView mTvGold;
    private TextView mTvNewPic;
    private TextView mTvCat;
    private TextView mTvLife;
    private TextView mTvStandbyApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dumpTasks(this);
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
        mTvPicContext = findViewById(R.id.tv_pic_context);
        mTvBeauty = findViewById(R.id.tv_beauty);
        mTvCar = findViewById(R.id.tv_car);
        mTvGold = findViewById(R.id.tv_gold);
        mTvNewPic = findViewById(R.id.tv_new_pic);
        mTvCat = findViewById(R.id.tv_cat);
        mTvLife = findViewById(R.id.tv_life);
        mTvStandbyApplication = findViewById(R.id.tv_standby_application);

        mTvRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClassActivity.launch(MainActivity.this, 1);
            }
        });

        mTvPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClassActivity.launch(MainActivity.this, 2);
            }
        });

        mTvVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClassActivity.launch(MainActivity.this, 3);
            }
        });
        mTvAgg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClassActivity.launch(MainActivity.this, 4);
            }
        });
        mTvCartoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClassActivity.launch(MainActivity.this, 5);
            }
        });
        mTvCookbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClassActivity.launch(MainActivity.this, 6);
            }
        });

        mTvPicContext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClassActivity.launch(MainActivity.this, 7);
            }
        });

        mTvBeauty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClassActivity.launch(MainActivity.this, 8);
            }
        });
        mTvCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClassActivity.launch(MainActivity.this, 9);
            }
        });
        mTvGold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClassActivity.launch(MainActivity.this, 10);
            }
        });
        mTvNewPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClassActivity.launch(MainActivity.this, 11);
            }
        });
        mTvCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClassActivity.launch(MainActivity.this, 12);
            }
        });
        mTvLife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClassActivity.launch(MainActivity.this, 13);
            }
        });

        mTvStandbyApplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "点击", Toast.LENGTH_SHORT).show();
//                DetailsActivity.launch(MainActivity.this, new NetUrlBean.DataEntity(0, "http://t.alpha.channel.45xie.com/ad.html", "备用代码位", 0, 0));
//                DetailsActivity.launch(MainActivity.this, new NetUrlBean.DataEntity(0, "http://t.alpha.channel.45xie.com/manhua/home.html?appid=B428109E4AA4E883DB8B1877BFF3575F", "测试菜谱", 0, 0));
                DetailsActivity.launch(MainActivity.this, new NetUrlBean.DataEntity(0, "http://t.alpha.channel.45xie.com/gamecat/index.html?appid=B428109E4AA4E883DB8B1877BFF3575F&id=debug", "游戏", 0, 0));
//                DetailsActivity.launch(MainActivity.this, new NetUrlBean.DataEntity(0, "https://m.xi5jie.com/install/land?channelCode=letu", "备用代码位", 0, 0));
//                DetailsActivity.launch(MainActivity.this, new NetUrlBean.DataEntity(0, "http://a.app.qq.com/o/simple.jsp?pkgname=com.xszn.ime&ckey=CK1429286954552", "备用代码位", 0, 0));
            }
        });

        initTest();
    }

    private void getNetUrl() {
        LogUtils.e("时间戳：" + System.currentTimeMillis());
        OkHttp3Utils.doPost(NetAddress.BASE_URL, mParmas, new GsonObjectCallback<NetUrlBean>() {
            @Override
            public void onUi(NetUrlBean netUrlBean) {
                if (netUrlBean.ret.equals("succ")) {
                    LogUtils.d("网络数据");
                    List<NetUrlBean.DataEntity> data = netUrlBean.data;
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
//        H5ReadAddressConstant h5ReadAddressConstant = new H5ReadAddressConstant();
//        H5AggregationAddressConstant h5AggregationAddressConstant = new H5AggregationAddressConstant();
//        H5PicAddressConstant h5PicAddressConstant = new H5PicAddressConstant();
//        H5VideoAddressConstant h5VideoAddressConstant = new H5VideoAddressConstant();
//        H5CookBookAddressConstant h5CookBookAddressConstant = new H5CookBookAddressConstant();
//        H5PicContextAddressConstant h5PicContextAddressConstant = new H5PicContextAddressConstant();
//        H5BeautyConstant h5BeautyConstant = new H5BeautyConstant();
//        H5CarConstant h5CarConstant = new H5CarConstant();
//
//        setReadLoc(h5ReadAddressConstant, mReadList);
//        setAggLoc(h5AggregationAddressConstant, mAggregationList);
//        setPicLoc(h5PicAddressConstant, mPicList);
//        setVideoLoc(h5VideoAddressConstant, mVideoList);
//        setCookBookLoc(h5CookBookAddressConstant, mCookBookList);
//        setPicContextLoc(h5PicContextAddressConstant, mPicContextList);
//        setBeautyLoc(h5BeautyConstant, mBeautyList);
//        setCarLoc(h5CarConstant, mCarList);

        H5Constant h5Constant = new H5Constant();
        setLoc(h5Constant, mReadList, 1);
        setLoc(h5Constant, mPicList, 2);
        setLoc(h5Constant, mVideoList, 3);
        setLoc(h5Constant, mAggregationList, 4);
        setLoc(h5Constant, mCartoonList, 5);
        setLoc(h5Constant, mCookBookList, 6);
        setLoc(h5Constant, mPicContextList, 7);
        setLoc(h5Constant, mBeautyList, 8);
        setLoc(h5Constant, mCarList, 9);
        setLoc(h5Constant, mGoldList, 10);
        setLoc(h5Constant, mNewPicList, 11);
    }

//    private void setReadLoc(H5ReadAddressConstant h5ReadAddressConstant, List<NetUrlBean.DataEntity> List) {
//        if (List != null && List.size() <= 0) {
//            for (int i = 0; i < h5ReadAddressConstant.ReadList.size(); i++) {
//                List.add(new NetUrlBean.DataEntity(i, h5ReadAddressConstant.ReadList.get(i).ChannelAddress, h5ReadAddressConstant.ReadList.get(i).ChannelName, 0, 0));
//            }
//        }
//    }
//
//    private void setAggLoc(H5AggregationAddressConstant h5AggregationAddressConstant, List<NetUrlBean.DataEntity> List) {
//        if (List != null && List.size() <= 0) {
//            for (int i = 0; i < h5AggregationAddressConstant.AggregationList.size(); i++) {
//                List.add(new NetUrlBean.DataEntity(i, h5AggregationAddressConstant.AggregationList.get(i).ChannelAddress, h5AggregationAddressConstant.AggregationList.get(i).ChannelName, 0, 0));
//            }
//        }
//    }
//
//    private void setVideoLoc(H5VideoAddressConstant h5VideoAddressConstant, List<NetUrlBean.DataEntity> List) {
//        if (List != null && List.size() <= 0) {
//            for (int i = 0; i < h5VideoAddressConstant.VideoList.size(); i++) {
//                List.add(new NetUrlBean.DataEntity(i, h5VideoAddressConstant.VideoList.get(i).ChannelAddress, h5VideoAddressConstant.VideoList.get(i).ChannelName, 0, 0));
//            }
//        }
//    }
//
//    private void setPicLoc(H5PicAddressConstant h5PicAddressConstant, List<NetUrlBean.DataEntity> List) {
//        if (List != null && List.size() <= 0) {
//            for (int i = 0; i < h5PicAddressConstant.PicList.size(); i++) {
//                List.add(new NetUrlBean.DataEntity(i, h5PicAddressConstant.PicList.get(i).ChannelAddress, h5PicAddressConstant.PicList.get(i).ChannelName, 0, 0));
//            }
//        }
//    }
//
//    private void setCookBookLoc(H5CookBookAddressConstant h5CookBookAddressConstant, List<NetUrlBean.DataEntity> List) {
//        if (List != null && List.size() <= 0) {
//            for (int i = 0; i < h5CookBookAddressConstant.CookBookList.size(); i++) {
//                List.add(new NetUrlBean.DataEntity(i, h5CookBookAddressConstant.CookBookList.get(i).ChannelAddress, h5CookBookAddressConstant.CookBookList.get(i).ChannelName, 0, 0));
//            }
//        }
//    }
//
//    private void setPicContextLoc(H5PicContextAddressConstant h5PicContextAddressConstant, List<NetUrlBean.DataEntity> List) {
//        if (List != null && List.size() <= 0) {
//            for (int i = 0; i < h5PicContextAddressConstant.PicContextList.size(); i++) {
//                List.add(new NetUrlBean.DataEntity(i, h5PicContextAddressConstant.PicContextList.get(i).ChannelAddress, h5PicContextAddressConstant.PicContextList.get(i).ChannelName, 0, 0));
//            }
//        }
//    }
//
//    /**
//     * 美妆链接
//     *
//     * @param h5BeautyConstant
//     * @param List
//     */
//    private void setBeautyLoc(H5BeautyConstant h5BeautyConstant, List<NetUrlBean.DataEntity> List) {
//        if (List != null && List.size() <= 0) {
//            for (int i = 0; i < h5BeautyConstant.BeautyList.size(); i++) {
//                List.add(new NetUrlBean.DataEntity(i, h5BeautyConstant.BeautyList.get(i).ChannelAddress, h5BeautyConstant.BeautyList.get(i).ChannelName, 0, 0));
//            }
//        }
//    }
//
//    /**
//     * 汽车链接
//     *
//     * @param h5CarConstant
//     * @param List
//     */
//    private void setCarLoc(H5CarConstant h5CarConstant, List<NetUrlBean.DataEntity> List) {
//        if (List != null && List.size() <= 0) {
//            for (int i = 0; i < h5CarConstant.CarList.size(); i++) {
//                List.add(new NetUrlBean.DataEntity(i, h5CarConstant.CarList.get(i).ChannelAddress, h5CarConstant.CarList.get(i).ChannelName, 0, 0));
//            }
//        }
//    }

    private void setLoc(H5Constant h5Constant, List<NetUrlBean.DataEntity> List, int index) {
        if (List != null && List.size() <= 0) {
            switch (index) {
                case 1:
                    for (int i = 0; i < h5Constant.ReadList.size(); i++) {
                        List.add(new NetUrlBean.DataEntity(i, h5Constant.ReadList.get(i).ChannelAddress, h5Constant.ReadList.get(i).ChannelName, 0, 0));
                    }
                    break;
                case 2:
                    for (int i = 0; i < h5Constant.PicList.size(); i++) {
                        List.add(new NetUrlBean.DataEntity(i, h5Constant.PicList.get(i).ChannelAddress, h5Constant.PicList.get(i).ChannelName, 0, 0));
                    }
                    break;
                case 3:
                    for (int i = 0; i < h5Constant.VideoList.size(); i++) {
                        List.add(new NetUrlBean.DataEntity(i, h5Constant.VideoList.get(i).ChannelAddress, h5Constant.VideoList.get(i).ChannelName, 0, 0));
                    }
                    break;
                case 4:
                    for (int i = 0; i < h5Constant.AggregationList.size(); i++) {
                        List.add(new NetUrlBean.DataEntity(i, h5Constant.AggregationList.get(i).ChannelAddress, h5Constant.AggregationList.get(i).ChannelName, 0, 0));
                    }
                    break;
                case 5:
                    for (int i = 0; i < h5Constant.CookBookList.size(); i++) {
                        List.add(new NetUrlBean.DataEntity(i, h5Constant.CookBookList.get(i).ChannelAddress, h5Constant.CookBookList.get(i).ChannelName, 0, 0));
                    }
                    break;
                case 6:
                    for (int i = 0; i < h5Constant.CartoonList.size(); i++) {
                        List.add(new NetUrlBean.DataEntity(i, h5Constant.CartoonList.get(i).ChannelAddress, h5Constant.CartoonList.get(i).ChannelName, 0, 0));
                    }
                    break;
                case 7:
                    for (int i = 0; i < h5Constant.PicContextList.size(); i++) {
                        List.add(new NetUrlBean.DataEntity(i, h5Constant.PicContextList.get(i).ChannelAddress, h5Constant.PicContextList.get(i).ChannelName, 0, 0));
                    }
                    break;
                case 8:
                    for (int i = 0; i < h5Constant.BeautyList.size(); i++) {
                        List.add(new NetUrlBean.DataEntity(i, h5Constant.BeautyList.get(i).ChannelAddress, h5Constant.BeautyList.get(i).ChannelName, 0, 0));
                    }
                    break;
                case 9:
                    for (int i = 0; i < h5Constant.CarList.size(); i++) {
                        List.add(new NetUrlBean.DataEntity(i, h5Constant.CarList.get(i).ChannelAddress, h5Constant.CarList.get(i).ChannelName, 0, 0));
                    }
                    break;
                case 10:
                    for (int i = 0; i < h5Constant.GoldList.size(); i++) {
                        List.add(new NetUrlBean.DataEntity(i, h5Constant.CarList.get(i).ChannelAddress, h5Constant.CarList.get(i).ChannelName, 0, 0));
                    }
                    break;
                case 11:
                    for (int i = 0; i < h5Constant.NewPicList.size(); i++) {
                        List.add(new NetUrlBean.DataEntity(i, h5Constant.CarList.get(i).ChannelAddress, h5Constant.CarList.get(i).ChannelName, 0, 0));
                    }
                    break;
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
                } else if (data.get(i).type == 7) {
                    mPicContextList.add(new NetUrlBean.DataEntity(mPicContextList.size(), data.get(i).url, data.get(i).name, data.get(i).pv, data.get(i).uv));
                    if (data.get(i).uv >= 100) {
                        mPicContextCount++;
                        mPicContextCountUv += data.get(i).uv;
                        mPicContextCountPv += data.get(i).pv;
                    }
                } else if (data.get(i).type == 8) {
                    mBeautyList.add(new NetUrlBean.DataEntity(mBeautyList.size(), data.get(i).url, data.get(i).name, data.get(i).pv, data.get(i).uv));
                    if (data.get(i).uv >= 100) {
                        mBeautyCount++;
                        mBeautyCountUv += data.get(i).uv;
                        mBeautyCountPv += data.get(i).pv;
                    }
                } else if (data.get(i).type == 9) {
                    mCarList.add(new NetUrlBean.DataEntity(mCarList.size(), data.get(i).url, data.get(i).name, data.get(i).pv, data.get(i).uv));
                    if (data.get(i).uv >= 100) {
                        mCarCount++;
                        mCarCountUv += data.get(i).uv;
                        mCarCountPv += data.get(i).pv;
                    }
                } else if (data.get(i).type == 10) {
                    mGoldList.add(new NetUrlBean.DataEntity(mGoldList.size(), data.get(i).url, data.get(i).name, data.get(i).pv, data.get(i).uv));
                    if (data.get(i).uv >= 100) {
                        mGoldCount++;
                        mGoldCountUv += data.get(i).uv;
                        mGoldCountPv += data.get(i).pv;
                    }
                } else if (data.get(i).type == 11) {
                    mNewPicList.add(new NetUrlBean.DataEntity(mNewPicList.size(), data.get(i).url, data.get(i).name, data.get(i).pv, data.get(i).uv));
                    if (data.get(i).uv >= 100) {
                        mNewPicCount++;
                        mNewPicCountUv += data.get(i).uv;
                        mNewPicCountPv += data.get(i).pv;
                    }
                } else if (data.get(i).type == 12) {
                    mCatList.add(new NetUrlBean.DataEntity(mCatList.size(), data.get(i).url, data.get(i).name, data.get(i).pv, data.get(i).uv));
                    if (data.get(i).uv >= 100) {
                        mCatCount++;
                        mCatCountUv += data.get(i).uv;
                        mCatCountPv += data.get(i).pv;
                    }
                } else if (data.get(i).type == 13) {
                    mLifeList.add(new NetUrlBean.DataEntity(mLifeList.size(), data.get(i).url, data.get(i).name, data.get(i).pv, data.get(i).uv));
                    if (data.get(i).uv >= 100) {
                        mLifeCount++;
                        mLifeCountUv += data.get(i).uv;
                        mLifeCountPv += data.get(i).pv;
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
            LogUtils.d(TAG + mBeautyList.size());
            LogUtils.d(TAG + mCarList.size());
            LogUtils.d(TAG + mCatList.size());
            LogUtils.d(TAG + mLifeList.size());
            LogUtils.d(TAG + mH5Count);
            mH5CountUv = mReadCountUv + mPicCountUv + mVideoCountUv + mAggCountUv + mCartoonCountUv + mCookBookCountUv + mPicContextCountUv + mBeautyCountUv + mCarCountUv + mGoldCountUv + mNewPicCountUv + mCatCountUv + mLifeCountUv;
            mH5CountPv = mReadCountPv + mPicCountPv + mVideoCountPv + mAggCountPv + mCartoonCountPv + mCookBookCountPv + mPicContextCountPv + mBeautyCountPv + mCarCountPv + mGoldCountPv + mNewPicCountPv + mCatCountPv + mLifeCountPv;
            H5Text(mTvH5Count, "H5链接数为(大于100UV):", mH5Count, mH5CountUv, mH5CountPv);
            H5Text(mTvRead, "H5小说:", mReadCount, mReadCountUv, mReadCountPv);
            H5Text(mTvPic, "H5美图:", mPicCount, mPicCountUv, mPicCountPv);
            H5Text(mTvVideo, "H5视频:", mVideoCount, mVideoCountUv, mVideoCountPv);
            H5Text(mTvAgg, "H5聚合:", mAggCount, mAggCountUv, mAggCountPv);
            H5Text(mTvCartoon, "H5漫画:", mCartoonCount, mCartoonCountUv, mCartoonCountPv);
            H5Text(mTvCookbook, "H5菜谱:", mCookBookCount, mCookBookCountUv, mCookBookCountPv);
            H5Text(mTvPicContext, "H5图文:", mPicContextCount, mPicContextCountUv, mPicContextCountPv);
            H5Text(mTvBeauty, "H5美妆:", mBeautyCount, mBeautyCountUv, mBeautyCountPv);
            H5Text(mTvCar, "H5汽车:", mCarCount, mCarCountUv, mCarCountPv);
            H5Text(mTvGold, "H5砸金蛋:", mGoldCount, mGoldCountUv, mGoldCountPv);
            H5Text(mTvNewPic, "H5新美图:", mNewPicCount, mNewPicCountUv, mNewPicCountPv);
            H5Text(mTvCat, "养猫游戏:", mCatCount, mCatCountUv, mCatCountPv);
            H5Text(mTvLife, "H5生活:", mLifeCount, mLifeCountUv, mLifeCountPv);
        }
    }

    private void H5Text(TextView textView, String name, int h5Count, int h5CountUv, int h5CountPv) {
        if (h5CountUv != 0) {
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

    private void dumpTasks(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> tasks = activityManager.getRunningTasks(20);
        for (ActivityManager.RunningTaskInfo task : tasks) {
            LogUtils.d(TAG + task.baseActivity.getPackageName());
        }
    }


    private void initTest() {
        Builder builder = new PhoneBuilder();
        Director director = new Director(builder);
        director.construct("18612345678", "one plus", "29");
        Phone phone = builder.create();

        Dog dog = new Dog.DogBuilder().age(4).color("red").name("flutter").build();

        Cat cat = new Cat.CatBuilder().name("luck").color("orgreen").build();

        LogUtils.d(TAG + "builder: " + dog.toString());


        CatFactory catFactory = new CatFactory();
//        Animal animal = catFactory.create();
        com.lt.h5project.factory.Cat cat1 = (com.lt.h5project.factory.Cat) catFactory.create();
        cat1.show();

        DogFactory dogFactory = new DogFactory();
        Animal animal = dogFactory.create();
        animal.show();
    }
}
