package com.lt.h5project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @author yeyang
 * @name H5project
 * @class name：com.lt.h5project
 * @class describe
 * @time 2019-07-03 18:55
 * @change
 * @chang time
 * @class describe
 */
public class AggregationH5Activity extends AppCompatActivity {
    private RecyclerView mRyAggregation;
    private AggregationAdapter mAggregationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h5_aggregation);
        findViewById(R.id.tv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mRyAggregation = findViewById(R.id.ry_aggregation);
        //设置布局管理器
        mRyAggregation.setLayoutManager(new LinearLayoutManager(this));

        H5AggregationAddressConstant h5AggregationAddressConstant = new H5AggregationAddressConstant();
        //设置adapter
        mRyAggregation.setAdapter(new AggregationAdapter(this,h5AggregationAddressConstant.AggregationList));
    }
}
