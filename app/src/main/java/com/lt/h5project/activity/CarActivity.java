package com.lt.h5project.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

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
public class CarActivity extends AppCompatActivity {
    private RecyclerView mCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h5_car);
        findViewById(R.id.tv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mCar = findViewById(R.id.ry_car);
        //设置布局管理器
        mCar.setLayoutManager(new LinearLayoutManager(this));
        mCar.setAdapter(new RecyclerviewAdapter(this,MainActivity.mCarList));
    }
}
