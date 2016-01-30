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
 * 数字适配器
 */
public class NumberedAdapter extends RecyclerView.Adapter<NumberedAdapter.ViewHolder> {

    private Context context;
    private List<String> labels;

    public NumberedAdapter(Context context, int count) {
        this.context = context;
        labels = new ArrayList<String>();
        for (int i = 0; i < count; i++) {
            labels.add(i + "");
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.numberedTV.setText(labels.get(position));
        holder.numberedTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, labels.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return labels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView numberedTV;

        public ViewHolder(View itemView) {
            super(itemView);
            numberedTV = (TextView) itemView.findViewById(R.id.numbered_tv);
        }
    }
}
