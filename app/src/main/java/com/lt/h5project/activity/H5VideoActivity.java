package com.lt.h5project.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lt.h5project.R;
import com.lt.h5project.adapter.VideoAdapter;
import com.lt.h5project.constant.H5VideoAddressConstant;

/**
 * @author yeyang
 * @name H5project
 * @class name：com.lt.h5project
 * @class describe
 * @time 2019-06-18 10:09
 * @change
 * @chang time
 * @class describe
 */
public class H5VideoActivity extends AppCompatActivity {
    private RecyclerView mRyVideo;
    private VideoAdapter mVideoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h5_video);
        findViewById(R.id.tv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mRyVideo = findViewById(R.id.ry_video);
        //设置布局管理器
        mRyVideo.setLayoutManager(new LinearLayoutManager(this));

        H5VideoAddressConstant h5VideoAddressConstant = new H5VideoAddressConstant();
        //设置adapter
        mRyVideo.setAdapter(new VideoAdapter(this, h5VideoAddressConstant.PicList));
    }
}
