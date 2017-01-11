package com.example.panagiotis.m_events.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.panagiotis.m_events.Fragments.ViewArtist;
import com.example.panagiotis.m_events.MainActivity;
import com.example.panagiotis.m_events.R;
import com.example.panagiotis.m_events.Realm_Models.LastFM_models.Temp_Realm;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.Example_lastFM;
import com.example.panagiotis.m_events.utils.ItemClickListener;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;


public class top_artists_adapter extends RecyclerView.Adapter<top_artists_adapter.ViewHolder> {

    private int row;
    Context context;
    private Example_lastFM example_lastFM;
    private MainActivity mainActivity;
    private Realm realm;

    public top_artists_adapter(int row, Example_lastFM example_lastFM,Context context,MainActivity mainActivity) {
        this.row = row;
        this.example_lastFM=example_lastFM;
        this.context=context;
        this.mainActivity=mainActivity;
    }

    @Override
    public top_artists_adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(row,parent,false);
        return new top_artists_adapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(top_artists_adapter.ViewHolder holder, int position) {

        holder.topArtistName.setText(example_lastFM.getTopartists().getArtist().get(position).getName());
        String s= String.valueOf(position+1);
        holder.numberArtist.setText(s);
        Picasso.with(context)
                .load(example_lastFM.getTopartists().getArtist().get(position).getImage().get(3).getText())
                .resize(164, 164)
                .centerCrop()
                .into(holder.topArtistImage);

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
                            temp_realm.setCheck(true);
                            temp_realm.setTempName(example_lastFM.getTopartists().getArtist().get(po).getName());
                            temp_realm.setTempID(example_lastFM.getTopartists().getArtist().get(po).getMbid());
                            temp_realm.setTempImage(example_lastFM.getTopartists().getArtist().get(po).getImage().get(3).getText());
                        }
                    });


                    mainActivity.fragment_transfer(new ViewArtist(),example_lastFM.getTopartists().getArtist().get(position).getName());
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return example_lastFM.getTopartists().getArtist().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        @BindView(R.id.topArtist_name) TextView topArtistName;
        @BindView(R.id.topArtist_num) TextView numberArtist;
        @BindView(R.id.topArtists_imageView) ImageView topArtistImage;
        @BindView(R.id.top_Artists_relativeLayout) RelativeLayout relativeLayout;
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
