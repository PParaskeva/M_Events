package com.example.panagiotis.m_events.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.panagiotis.m_events.R;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.songkick.SongKick_ArtistCalendar.Example_ArtistCalendar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Panagiotis on 11/01/2017.
 */

public class artistCalendar_adaptor extends RecyclerView.Adapter<artistCalendar_adaptor.ViewHolder> {
    private int row;
    private Example_ArtistCalendar example_artistCalendar;
    private Context context;

    public artistCalendar_adaptor(int row, Example_ArtistCalendar example_artistCalendar, Context context) {
        this.row = row;
        this.example_artistCalendar = example_artistCalendar;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(row,parent,false);
        return new artistCalendar_adaptor.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String s= String.valueOf(position+1);
        holder.indexArtistCalenda.setText(s);
        holder.cityName.setText("City :"+example_artistCalendar.getResultsPage().getResults().getEvent().get(position).getLocation().getCity());
        holder.eventName.setText(example_artistCalendar.getResultsPage().getResults().getEvent().get(position).getDisplayName());
        holder.venueName.setText("Venue :"+example_artistCalendar.getResultsPage().getResults().getEvent().get(position).getVenue().getDisplayName());
    }

    @Override
    public int getItemCount() {
        return example_artistCalendar.getResultsPage().getResults().getEvent().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.artistCalendar_cityName) TextView cityName;
        @BindView(R.id.artistCalendar_eventName) TextView eventName;
        @BindView(R.id.artistCalendar_venueName) TextView venueName;
        @BindView(R.id.ArtistCalendar_index) TextView indexArtistCalenda;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
