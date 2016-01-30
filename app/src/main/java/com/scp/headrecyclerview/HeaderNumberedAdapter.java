package com.scp.headrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * 带头布局的适配器
 */
public class HeaderNumberedAdapter extends RecyclerView.Adapter<HeaderNumberedAdapter.ViewHolder> {
    private Context context;
    private View header;
    private List<String> labels;
    private int ITEM_VIEW_TYPE_HEADER = 0;
    private int ITEM_VIEW_TYPE_ITEM = 1;

    public HeaderNumberedAdapter(Context context, View header, int count) {
        this.context = context;
        this.header = header;
        labels = new ArrayList<String>();
        for (int i = 0; i < count; i++) {
            labels.add(i + "");
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_VIEW_TYPE_HEADER) {
            return new ViewHolder(header);
        }
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        if (isHeader(position)) {
            return;
        }
        holder.numberedTV.setText(labels.get(position - 1));
        holder.numberedTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, labels.get(position - 1), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return labels.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        return isHeader(position) ? ITEM_VIEW_TYPE_HEADER : ITEM_VIEW_TYPE_ITEM;
    }

    /**
     * 判断是否为头布局
     *
     * @param position 当前Item
     * @return 为头布局返回true，否则返回false
     */
    public boolean isHeader(int position) {
        return position == 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView numberedTV;

        public ViewHolder(View itemView) {
            super(itemView);
            numberedTV = (TextView) itemView.findViewById(R.id.numbered_tv);
        }
    }
}
