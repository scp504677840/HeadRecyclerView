package com.scp.headrecyclerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;

/**
 * 自动调整的RecyclerView
 */
public class AutoFitRecyclerView extends RecyclerView {

    private int columnWidth;
    private GridLayoutManager manager;

    public AutoFitRecyclerView(Context context) {
        this(context, null);
    }

    public AutoFitRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AutoFitRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        //如果attrs不为空
        if (attrs != null) {
            int[] attrsArray = {android.R.attr.columnWidth};
            TypedArray array = context.obtainStyledAttributes(attrs, attrsArray);
            //拿到每列的宽
            columnWidth = array.getDimensionPixelSize(0, -1);
            Log.e("AutoFitRecyclerView", "列宽：" + columnWidth);
            //释放资源
            array.recycle();
        }
        //设置显示方式
        manager = new GridLayoutManager(getContext(), 1);
        setLayoutManager(manager);
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        super.onMeasure(widthSpec, heightSpec);
        if (columnWidth > 0) {
            int spanCount = Math.max(1, getMeasuredWidth() / columnWidth);
            manager.setSpanCount(spanCount);
        }
    }
}
