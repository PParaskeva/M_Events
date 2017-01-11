package com.example.panagiotis.m_events.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.panagiotis.m_events.MainActivity;
import com.example.panagiotis.m_events.R;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.songkick.Example_songkick;

import butterknife.BindView;
import butterknife.ButterKnife;


public class musicEvents_adaptor extends RecyclerView.Adapter<musicEvents_adaptor.ViewHolder> {
    private int row;
    private Context context;
    private MainActivity mainActivity;
    private Example_songkick example_songkick;

    public musicEvents_adaptor(int row, Context context, MainActivity mainActivity, Example_songkick example_songkick) {
        this.row = row;
        this.context = context;
        this.mainActivity = mainActivity;
        this.example_songkick = example_songkick;
    }

    @Override
    public musicEvents_adaptor.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(row,parent,false);
        return new musicEvents_adaptor.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(musicEvents_adaptor.ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return example_songkick.getResultsPage().getTotalEntries();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.musicEvents_TextView) TextView name;
        @BindView(R.id.musicEvents_imageView) ImageView image;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
//            image=(ImageView) itemView.findViewById(R.id.musicEvents_imageView);
//            name=(TextView) itemView.findViewById(R.id.musicEvents_TextView);
        }
    }
}
