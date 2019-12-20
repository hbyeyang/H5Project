package com.lt.h5project.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.lt.h5project.R;
import com.lt.h5project.adapter.RecyclerviewAdapter;

/**
 * @author yeyang
 * @name H5project
 * @class name：com.lt.h5project.activity
 * @class describe
 * @time 2019-07-24 18:15
 * @change
 * @chang time
 * @class describe
 */
public class ClassActivity extends AppCompatActivity {
    private TextView mTvTitle;
    private RecyclerView mRecyclerView;

    public static void launch(Context context, int index) {
        Intent intent = new Intent(context, ClassActivity.class);
        intent.putExtra("data", index);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_h5);
        findViewById(R.id.tv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mTvTitle = findViewById(R.id.tv_title);
        mRecyclerView = findViewById(R.id.recycler);
        //设置布局管理器
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        int data = getIntent().getIntExtra("data", 0);
//        setLoc(h5Constant, mReadList, 1);
//        setLoc(h5Constant, mAggregationList, 2);
//        setLoc(h5Constant, mPicList, 3);
//        setLoc(h5Constant, mVideoList, 4);
//        setLoc(h5Constant, mCookBookList, 5);
//        setLoc(h5Constant, mPicContextList, 6);
//        setLoc(h5Constant, mBeautyList, 7);
//        setLoc(h5Constant, mCarList, 8);
//        setLoc(h5Constant, mGoldList, 9);
//        setLoc(h5Constant, mNewPicList, 10);
        switch (data) {
            case 1:
                mTvTitle.setText("H5小说");
                mRecyclerView.setAdapter(new RecyclerviewAdapter(this, MainActivity.mReadList));
                break;
            case 2:
                mTvTitle.setText("H5美图");
                mRecyclerView.setAdapter(new RecyclerviewAdapter(this, MainActivity.mPicList));
                break;
            case 3:
                mTvTitle.setText("H5视频");
                mRecyclerView.setAdapter(new RecyclerviewAdapter(this, MainActivity.mVideoList));
                break;
            case 4:
                mTvTitle.setText("H5聚合");
                mRecyclerView.setAdapter(new RecyclerviewAdapter(this, MainActivity.mAggregationList));
                break;
            case 5:
                mTvTitle.setText("H5漫画");
                mRecyclerView.setAdapter(new RecyclerviewAdapter(this, MainActivity.mCartoonList));
                break;
            case 6:
                mTvTitle.setText("H5菜谱");
                mRecyclerView.setAdapter(new RecyclerviewAdapter(this, MainActivity.mCookBookList));
                break;
            case 7:
                mTvTitle.setText("H5图文");
                mRecyclerView.setAdapter(new RecyclerviewAdapter(this, MainActivity.mPicContextList));
                break;
            case 8:
                mTvTitle.setText("H5美妆");
                mRecyclerView.setAdapter(new RecyclerviewAdapter(this, MainActivity.mBeautyList));
                break;
            case 9:
                mTvTitle.setText("H5汽车");
                mRecyclerView.setAdapter(new RecyclerviewAdapter(this, MainActivity.mCarList));
                break;
            case 10:
                mTvTitle.setText("H5砸金蛋");
                mRecyclerView.setAdapter(new RecyclerviewAdapter(this, MainActivity.mGoldList));
                break;
            case 11:
                mTvTitle.setText("H5新美图");
                mRecyclerView.setAdapter(new RecyclerviewAdapter(this, MainActivity.mNewPicList));
                break;
            case 12:
                mTvTitle.setText("养猫游戏");
                mRecyclerView.setAdapter(new RecyclerviewAdapter(this, MainActivity.mCatList));
                break;
            case 13:
                mTvTitle.setText("生活");
                mRecyclerView.setAdapter(new RecyclerviewAdapter(this, MainActivity.mLifeList));
                break;
        }
    }
}
