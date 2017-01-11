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
import com.example.panagiotis.m_events.Realm_Models.LastFM_models.FavoriteArtists_Realm;
import com.example.panagiotis.m_events.utils.ItemClickListener;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmResults;

/**
 * Created by Panagiotis on 09/01/2017.
 */

public class FavorityArtists_Adaport extends RecyclerView.Adapter<FavorityArtists_Adaport.ViewHolder> {

    private int row;
    private Context context;
    private MainActivity mainActivity;
    private RealmResults<FavoriteArtists_Realm> resultsFavorityArtists;

    public FavorityArtists_Adaport(int row, Context context, MainActivity mainActivity, RealmResults<FavoriteArtists_Realm> resultsFavorityArtists) {
        this.row = row;
        this.context = context;
        this.mainActivity = mainActivity;
        this.resultsFavorityArtists = resultsFavorityArtists;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(row,parent,false);
        return new FavorityArtists_Adaport.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        String s= String.valueOf(position+1);
        holder.index.setText(s);
        holder.ArtistName.setText(resultsFavorityArtists.get(position).getArtistName());
        Picasso.with(context)
                .load(resultsFavorityArtists.get(position).getArtistImage())
                .resize(164, 164)
                .centerCrop()
                .into(holder.ArtistImage);
    }

    @Override
    public int getItemCount() {
        return resultsFavorityArtists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        private ItemClickListener itemClickListener;


        @BindView(R.id.FavorityArtists_Index) TextView index;
        @BindView(R.id.FavorityArtists_Name) TextView ArtistName;
        @BindView(R.id.imageView2) ImageView ArtistImage;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void setClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View view) {
            itemClickListener.onClick(view, getPosition(), false);
        }

        @Override
        public boolean onLongClick(View view) {

            itemClickListener.onClick(view, getPosition(), true);
            return true;
        }
    }
}
