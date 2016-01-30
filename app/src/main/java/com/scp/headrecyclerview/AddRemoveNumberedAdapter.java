package com.scp.headrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * 添加和删除布局
 */
public class AddRemoveNumberedAdapter extends RecyclerView.Adapter<AddRemoveNumberedAdapter.ViewHolder> {
    private Context context;
    private List<String> labels;
    private int ITEM_VIEW_TYPE_ITEM = 0;
    private int ITEM_VIEW_TYPE_ADD = 1;

    public AddRemoveNumberedAdapter(Context context, int count) {
        this.context = context;
        labels = new ArrayList<String>();
        for (int i = 0; i < count; i++) {
            labels.add(i + "");
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(viewType == ITEM_VIEW_TYPE_ADD ? R.layout.item_add : R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Log.e("MainActivity", "position:" + position + ",getPosition:" + holder.getPosition() + ",getLayoutPosition" + holder.getLayoutPosition());
        if (position == labels.size()) {
            holder.numberedTV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addItem();
                }
            });
            return;
        }

        holder.numberedTV.setText(labels.get(position));
        holder.numberedTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(holder.getLayoutPosition());
            }
        });
    }

    private void removeItem(int layoutPosition) {
        labels.remove(layoutPosition);
        notifyItemRemoved(layoutPosition);
    }

    private void addItem() {
        if (labels.size() >= 1) {
            int lastItem = Integer.parseInt(labels.get(labels.size() - 1));
            labels.add(lastItem + 1 + "");
            notifyItemInserted(labels.size() - 1);
        } else {
            labels.add(new String("0"));
            notifyItemInserted(0);
        }
    }

    @Override
    public int getItemCount() {
        return labels.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        return position == labels.size() ? ITEM_VIEW_TYPE_ADD : ITEM_VIEW_TYPE_ITEM;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView numberedTV;

        public ViewHolder(View itemView) {
            super(itemView);
            numberedTV = (TextView) itemView.findViewById(R.id.numbered_tv);
        }
    }
}
