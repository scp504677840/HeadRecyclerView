package com.scp.headrecyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;

/**
 * 表格可变的跨列
 */
public class GridLayoutVariableSpanSizeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        AutoFitRecyclerView mAutoFitRecyclerView = (AutoFitRecyclerView) findViewById(R.id.main_rv);
        //设置分隔线
        mAutoFitRecyclerView.addItemDecoration(new MarginDecoration(this));
        //保持大小不变
        mAutoFitRecyclerView.setHasFixedSize(true);
        //设置显示方式
        GridLayoutManager manager = new GridLayoutManager(this, 3);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return (3 - position % 3);
            }
        });
        mAutoFitRecyclerView.setLayoutManager(manager);
        //设置适配器
        mAutoFitRecyclerView.setAdapter(new NumberedAdapter(this, 30));
    }
}
