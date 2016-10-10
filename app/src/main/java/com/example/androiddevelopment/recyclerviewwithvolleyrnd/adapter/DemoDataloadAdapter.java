package com.example.androiddevelopment.recyclerviewwithvolleyrnd.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androiddevelopment.recyclerviewwithvolleyrnd.R;
import com.example.androiddevelopment.recyclerviewwithvolleyrnd.model.DemoDataHandler;

import java.util.List;

/**
 * Created by Android Development on 10/9/2016.
 */

public class DemoDataloadAdapter extends RecyclerView.Adapter<DemoDataloadAdapter.MyDemoListViewHolder> {

    private List<DemoDataHandler> demoInfo;
    Context context;

    public DemoDataloadAdapter(List<DemoDataHandler> demoInfo, Context context) {
        this.demoInfo = demoInfo;
        this.context = context;
    }

    public DemoDataloadAdapter() {

    }

    public class MyDemoListViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewEmail;
        TextView textViewAddress;
        public MyDemoListViewHolder(View itemView) {
            super(itemView);

            textViewName = (TextView)itemView.findViewById(R.id.tv_rowview_name);
            textViewEmail = (TextView)itemView.findViewById(R.id.tv_rowview_email);
            textViewAddress = (TextView)itemView.findViewById(R.id.tv_rowview_address);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Item Clicked", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public DemoDataloadAdapter.MyDemoListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowview, parent, false);
        DemoDataloadAdapter.MyDemoListViewHolder holder = new DemoDataloadAdapter.MyDemoListViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(DemoDataloadAdapter.MyDemoListViewHolder holder, int position) {
        holder.textViewName.setText(demoInfo.get(position).getUsername());
        holder.textViewEmail.setText(demoInfo.get(position).getEmail());
        holder.textViewAddress.setText(demoInfo.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return demoInfo.size();
    }


}
