package com.example.panagiotis.m_events.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.panagiotis.m_events.Fragments.ViewTrack;
import com.example.panagiotis.m_events.MainActivity;
import com.example.panagiotis.m_events.R;
import com.example.panagiotis.m_events.Realm_Models.LastFM_models.Temp_Realm;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.Example_topTracks;
import com.example.panagiotis.m_events.utils.ItemClickListener;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;


public class top_tracks_adapter extends RecyclerView.Adapter<top_tracks_adapter.ViewHolder> {

    private int row;
    private MainActivity mainActivity;
    private Context context;
    private Example_topTracks example_topTracks;
    private Realm realm;

    public top_tracks_adapter(int row, Context context, Example_topTracks example_topTracks,MainActivity mainActivity) {
        this.row = row;
        this.context = context;
        this.example_topTracks=example_topTracks;
        this.mainActivity=mainActivity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(row,parent,false);
        return new top_tracks_adapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.songName_topTrack.setText(example_topTracks.getTracks().getTrack().get(position).getName());
        holder.artistName_topTrack.setText(example_topTracks.getTracks().getTrack().get(position).getArtist().getName());
        String s= String.valueOf(position+1);
        holder.rank_topTrack.setText(s);

        Picasso.with(context)
                .load(example_topTracks.getTracks().getTrack().get(position).getImage().get(3).getText())
                .resize(164, 164)
                .centerCrop()
                .into(holder.trackImageUrl);

        holder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if(!isLongClick){
                    final int po=position;
                    realm = Realm.getDefaultInstance();
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            realm.delete(Temp_Realm.class);
                        }
                    });

                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            Temp_Realm temp_realm = realm.createObject(Temp_Realm.class);
                            temp_realm.setCheck(false);
                            temp_realm.setTempName(example_topTracks.getTracks().getTrack().get(po).getName());
                            temp_realm.setTempID(example_topTracks.getTracks().getTrack().get(po).getMbid());
                            temp_realm.setTempImage(example_topTracks.getTracks().getTrack().get(po).getImage().get(3).getText());
                            temp_realm.setTempArtisName(example_topTracks.getTracks().getTrack().get(po).getArtist().getName());
                        }
                    });
                    mainActivity.fragment_transfer(new ViewTrack(),example_topTracks.getTracks().getTrack().get(position).getArtist().getName()
                            ,example_topTracks.getTracks().getTrack().get(position).getName(),
                            example_topTracks.getTracks().getTrack().get(position).getImage().get(3).getText());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return example_topTracks.getTracks().getTrack().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener, View.OnLongClickListener {

        @BindView(R.id.track_name_top_tracks) TextView songName_topTrack;
        @BindView(R.id.artists_name_top_tracks) TextView artistName_topTrack;
        @BindView(R.id.rank_textView_top_tracks) TextView rank_topTrack;
        @BindView(R.id.imageView) ImageView trackImageUrl;
        @BindView(R.id.topTrack_relativyLayout) RelativeLayout relativeLayout;

        private ItemClickListener itemClickListener;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            relativeLayout.setOnClickListener(this);
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
