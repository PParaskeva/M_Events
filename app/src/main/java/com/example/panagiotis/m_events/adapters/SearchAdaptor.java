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
import com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.Artists_Search.Example_SearchArtists;
import com.example.panagiotis.m_events.utils.ItemClickListener;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;


public class SearchAdaptor extends RecyclerView.Adapter<SearchAdaptor.ViewHolder> {
    private int row;
    private Context context;
    private MainActivity mainActivity;
    private Example_SearchArtists example_searchArtists;
    private Realm realm;

    public SearchAdaptor(int row, Context context, MainActivity mainActivity, Example_SearchArtists example_searchArtists) {
        this.row = row;
        this.context = context;
        this.mainActivity = mainActivity;
        this.example_searchArtists = example_searchArtists;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(row,parent,false);
        return new SearchAdaptor.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(example_searchArtists.getResults().getArtistmatches().getArtist().get(position).getImage().get(3).getText().length()>0) {
        String s= String.valueOf(position+1);
        holder.index.setText(s);
        holder.name.setText(example_searchArtists.getResults().getArtistmatches().getArtist().get(position).getName());

            Picasso.with(context)
                    .load(example_searchArtists.getResults().getArtistmatches().getArtist().get(position).getImage().get(3).getText())
                    .resize(164, 164)
                    .centerCrop()
                    .into(holder.ArtistImage);
        }
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
                            temp_realm.setTempName(example_searchArtists.getResults().getArtistmatches().getArtist().get(po).getName());
                            temp_realm.setTempID(example_searchArtists.getResults().getArtistmatches().getArtist().get(po).getMbid());
                            temp_realm.setTempImage(example_searchArtists.getResults().getArtistmatches().getArtist().get(po).getImage().get(3).getText());
                        }
                    });
                    mainActivity.fragment_transfer(new ViewArtist(),example_searchArtists.getResults().getArtistmatches().getArtist().get(position).getName());
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return example_searchArtists.getResults().getArtistmatches().getArtist().size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        @BindView(R.id.SearchArtists_index) TextView index;
        @BindView(R.id.SearchArtists_imageView) ImageView ArtistImage;
        @BindView(R.id.SearchArtists_name) TextView name;
        @BindView(R.id.RelativeLayout_SearchArtists) RelativeLayout searchArtistLayout;
        private ItemClickListener itemClickListener;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            searchArtistLayout.setOnClickListener(this);
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
