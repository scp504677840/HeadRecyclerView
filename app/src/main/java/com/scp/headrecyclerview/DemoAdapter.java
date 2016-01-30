package com.scp.headrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Demo适配器
 */
public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.ViewHolder> {
    private Context context;
    private Demo[] demos;

    public DemoAdapter(Context context, Demo[] demos) {
        this.context = context;
        this.demos = demos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Demo demo = demos[position];
        holder.numberedTV.setText(demo.getTitle());
        holder.numberedTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, demo.getActivityClass()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return demos.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView numberedTV;

        public ViewHolder(View itemView) {
            super(itemView);
            numberedTV = (TextView) itemView.findViewById(R.id.numbered_tv);
        }
    }
}
