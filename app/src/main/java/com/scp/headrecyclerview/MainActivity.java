package com.scp.headrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

public class MainActivity extends AppCompatActivity {

    private AutoFitRecyclerView mAutoFitRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        //创建Demo数组用来存储Demo
        Demo[] demos = {new Demo(LinearLayoutActivity.class, "线性"),
                new Demo(GridLayoutActivity.class, "表格"),
                new Demo(GridLayoutVariableSpanSizeActivity.class, "表格可变的跨列"),
                new Demo(GridLayoutHeaderActivity.class, "带头布局的表格"),
                new Demo(GridLayoutAutoFitActivity.class, "全自动布局"),
                new Demo(GridLayoutAutoHeaderActivity.class, "带头布局的全自动布局"),
                new Demo(GridLayoutAddRemoveActivity.class, "添加删除布局")
        };

        //获取RecyclerView
        mAutoFitRecyclerView = (AutoFitRecyclerView) findViewById(R.id.main_rv);
        //添加分隔线
        mAutoFitRecyclerView.addItemDecoration(new MarginDecoration(this));
        //保持大小不变
        mAutoFitRecyclerView.setHasFixedSize(true);
        //设置显示方式
        mAutoFitRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //设置适配器
        mAutoFitRecyclerView.setAdapter(new DemoAdapter(this, demos));

    }
}
