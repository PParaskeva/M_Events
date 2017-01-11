package com.example.panagiotis.m_events.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.panagiotis.m_events.R;
import com.example.panagiotis.m_events.Realm_Models.LastFM_models.FavorityTags_Realm;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.Example_ArtistGetInfo;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.track_info.Tag_TrackInfo;
import com.example.panagiotis.m_events.utils.ItemClickListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmResults;


public class button_tags_adapter extends RecyclerView.Adapter<button_tags_adapter.ViewHolder> {
    private int row;
    List<Tag_TrackInfo> tag;
    Example_ArtistGetInfo example_artistGetInfo;
    private Realm realm;
    boolean check=true;
    Context context;

    public button_tags_adapter(int row, List<Tag_TrackInfo> tag,Context context) {
        this.row=row;
        this.tag=tag;
        this.context=context;
    }

    public button_tags_adapter(int row, Example_ArtistGetInfo example_artistGetInfo,boolean check,Context context) {
        this.row=row;
        this.example_artistGetInfo=example_artistGetInfo;
        this.check=check;
        this.context=context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(row,parent,false);
        return new button_tags_adapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final int po=position;

        String name="";
        if(check){
            //holder.buttonTag.setText(tag.get(position).getName());
            name=tag.get(position).getName();
        }
        else {
            //holder.buttonTag.setText(example_artistGetInfo.getArtist().getTags().getTag().get(position).getName());
            name=example_artistGetInfo.getArtist().getTags().getTag().get(position).getName();
        }

        holder.buttonTag.setText(name);
        holder.buttonTag.setBackgroundResource(android.R.drawable.btn_default);

        realm = Realm.getDefaultInstance();
        RealmResults<FavorityTags_Realm> favorityTags_realms = realm.where(FavorityTags_Realm.class).equalTo("tagName", name).findAll();
        if(favorityTags_realms.size()!=0){
            if(favorityTags_realms.get(0).isValue()) {
                holder.buttonTag.setBackgroundColor(Color.BLUE);
            }
        }

        final String finalName = name;
        holder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if(!isLongClick){
                    final RealmResults<FavorityTags_Realm> results = realm.where(FavorityTags_Realm.class).equalTo("tagName", finalName).findAll();
                    if(results.size()==0){
                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                FavorityTags_Realm favorityTagsRealm = realm.createObject(FavorityTags_Realm.class);
                                favorityTagsRealm.setTagName(finalName);
                                favorityTagsRealm.setValue(true);
                            }
                        });
                        holder.buttonTag.setBackgroundColor(Color.BLUE);
                        Toast.makeText(context, "The tag is added to Favorites", Toast.LENGTH_SHORT).show();
                    }
                    if(results.size()!=0) {
                        if (results.get(0).isValue()) {
                            realm.executeTransaction(new Realm.Transaction() {
                                @Override
                                public void execute(Realm realm) {
                                    results.get(0).setValue(false);
                                }
                            });
                            holder.buttonTag.setBackgroundResource(android.R.drawable.btn_default);
                            Toast.makeText(context, "The tag is removed from Favorites", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            realm.executeTransaction(new Realm.Transaction() {
                                @Override
                                public void execute(Realm realm) {
                                    results.get(0).setValue(true);
                                }
                            });
                            holder.buttonTag.setBackgroundColor(Color.BLUE);
                            Toast.makeText(context, "The tag is added to Favorites", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        int temp=0;
        if(check){
            temp=tag.size();
        }
        else {
            temp=example_artistGetInfo.getArtist().getTags().getTag().size();
        }
        return temp;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
//        Button buttonTag;
        @BindView(R.id.tagButton) Button buttonTag;
        private ItemClickListener itemClickListener;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            buttonTag.setOnClickListener(this);
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
