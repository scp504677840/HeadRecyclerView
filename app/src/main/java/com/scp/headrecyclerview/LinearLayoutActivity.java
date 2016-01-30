package com.scp.headrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

/**
 * LinearLayoutActivity
 */
public class LinearLayoutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        AutoFitRecyclerView mAutoFitRecyclerView = (AutoFitRecyclerView) findViewById(R.id.main_rv);
        //添加分隔线
        mAutoFitRecyclerView.addItemDecoration(new MarginDecoration(this));
        //保持大小不变
        mAutoFitRecyclerView.setHasFixedSize(true);
        //设置显示方式
        mAutoFitRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //设置适配器
        mAutoFitRecyclerView.setAdapter(new NumberedAdapter(this, 30));
    }
}
