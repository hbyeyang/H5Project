package com.lt.h5project.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lt.h5project.R;
import com.lt.h5project.adapter.RecyclerviewAdapter;
import com.lt.h5project.constant.H5ReadAddressConstant;

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
public class H5ReadActivity extends AppCompatActivity {

    private RecyclerView mRyRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h5_read);
        findViewById(R.id.tv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mRyRead = findViewById(R.id.ry_read);
        //设置布局管理器
        mRyRead.setLayoutManager(new LinearLayoutManager(this));

        H5ReadAddressConstant h5ReadAddressConstant = new H5ReadAddressConstant();
        //设置adapter
        mRyRead.setAdapter(new RecyclerviewAdapter(this,h5ReadAddressConstant.ReadList));
    }
}
