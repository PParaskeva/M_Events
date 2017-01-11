package com.example.panagiotis.m_events.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.panagiotis.m_events.MainActivity;
import com.example.panagiotis.m_events.R;
import com.example.panagiotis.m_events.Realm_Models.LastFM_models.FavotiteTracks_Realm;
import com.example.panagiotis.m_events.utils.ItemClickListener;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmResults;

/**
 * Created by Panagiotis on 09/01/2017.
 */

public class FavorityTracks_adaptor extends RecyclerView.Adapter<FavorityTracks_adaptor.ViewHolder> {

    private int row;
    private Context context;
    private MainActivity mainActivity;
    private RealmResults<FavotiteTracks_Realm> resultsFavorityTracks;

    public FavorityTracks_adaptor(int row, Context context, MainActivity mainActivity, RealmResults<FavotiteTracks_Realm> resultsFavorityTracks) {
        this.row = row;
        this.context = context;
        this.mainActivity = mainActivity;
        this.resultsFavorityTracks = resultsFavorityTracks;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(row,parent,false);
        return new FavorityTracks_adaptor.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String s= String.valueOf(position+1);
        holder.index.setText(s);
        holder.name.setText(resultsFavorityTracks.get(position).getTrackName());
        Picasso.with(context)
                .load(resultsFavorityTracks.get(position).getTrackImage())
                .resize(164, 164)
                .centerCrop()
                .into(holder.image);
        holder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return resultsFavorityTracks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        @BindView(R.id.FavorityTracks_name) TextView name;
        @BindView(R.id.FavorityTracks_imageView) ImageView image;
        @BindView(R.id.FavorityTracks_index) TextView index;
        @BindView(R.id.FavorityTrackRelativyLayout) RelativeLayout FavorityTrack_relativeLayout;
        private ItemClickListener itemClickListener;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            FavorityTrack_relativeLayout.setOnClickListener(this);
        }

        public void setClickListener(ItemClickListener itemClickListener){
            this.itemClickListener=itemClickListener;
        }

        @Override
        public void onClick(View view) {
            itemClickListener.onClick(view,getPosition(),false);
        }

        @Override
        public boolean onLongClick(View view) {
            itemClickListener.onClick(view, getPosition(), true);
            return true;
        }
    }
}
