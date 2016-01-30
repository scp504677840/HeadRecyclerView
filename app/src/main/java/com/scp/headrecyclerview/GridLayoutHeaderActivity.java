package com.scp.headrecyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

/**
 * 带头布局的表格
 */
public class GridLayoutHeaderActivity extends AppCompatActivity {
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

        //获取头布局
        View header = LayoutInflater.from(this).inflate(R.layout.header, mAutoFitRecyclerView, false);
        header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GridLayoutHeaderActivity.this, "我是头布局", Toast.LENGTH_SHORT).show();
            }
        });
        //设置适配器
        final HeaderNumberedAdapter adapter = new HeaderNumberedAdapter(this, header, 30);
        mAutoFitRecyclerView.setAdapter(adapter);

        //设置显示方式
        final GridLayoutManager manager = new GridLayoutManager(this, 2);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return adapter.isHeader(position) ? manager.getSpanCount() : 1;
            }
        });
        mAutoFitRecyclerView.setLayoutManager(manager);
    }
}
