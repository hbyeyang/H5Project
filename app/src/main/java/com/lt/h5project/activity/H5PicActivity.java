package com.lt.h5project.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lt.h5project.R;
import com.lt.h5project.adapter.PicAdapter;
import com.lt.h5project.adapter.ReadAdapter;
import com.lt.h5project.constant.H5PicAddressConstant;

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
public class H5PicActivity extends AppCompatActivity {
    private RecyclerView mRyPic;
    private PicAdapter mPicAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h5_pic);
        findViewById(R.id.tv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mRyPic = findViewById(R.id.ry_pic);
        //设置布局管理器
        mRyPic.setLayoutManager(new LinearLayoutManager(this));

        H5PicAddressConstant h5PicAddressConstant = new H5PicAddressConstant();
        //设置adapter
        mRyPic.setAdapter(new PicAdapter(this,h5PicAddressConstant.PicList));
    }
}
