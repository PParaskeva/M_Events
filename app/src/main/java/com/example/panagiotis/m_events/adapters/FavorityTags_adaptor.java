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
import com.example.panagiotis.m_events.utils.ItemClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmResults;


public class FavorityTags_adaptor extends RecyclerView.Adapter<FavorityTags_adaptor.ViewHolder> {

    private Realm realm;
    RealmResults<FavorityTags_Realm> resultsTags;
    Context context;
    int buttontags_row;

    public FavorityTags_adaptor(RealmResults<FavorityTags_Realm> resultsTags, Context context, int buttontags_row) {
        this.resultsTags = resultsTags;
        this.context = context;
        this.buttontags_row = buttontags_row;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(buttontags_row,parent,false);
        return new FavorityTags_adaptor.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        if(resultsTags.get(position).isValue()){
            holder.tagBt.setBackgroundColor(Color.BLUE);
        }
        else {
            //holder.tagBt.setBackgroundResource(android.R.drawable.btn_default);
            holder.tagBt.setVisibility(View.GONE);
        }
        holder.tagBt.setText(resultsTags.get(position).getTagName());
        holder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                realm = Realm.getDefaultInstance();
                boolean check=true;
                if(!isLongClick){
                    if(!resultsTags.get(position).isValue()){
                        final RealmResults<FavorityTags_Realm> results = realm.where(FavorityTags_Realm.class).
                                equalTo("tagName", resultsTags.get(position).getTagName()).findAll();
                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                results.get(0).setValue(true);
                            }
                        });
                        holder.tagBt.setBackgroundColor(Color.BLUE);
                        Toast.makeText(context, "The tag is added to Favorites", Toast.LENGTH_SHORT).show();
                        check=false;
                    }

                    if(resultsTags.get(position).isValue() && check){
                        final RealmResults<FavorityTags_Realm> results = realm.where(FavorityTags_Realm.class).
                                equalTo("tagName", resultsTags.get(position).getTagName()).findAll();
                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                results.get(0).setValue(false);
                            }
                        });
                        Toast.makeText(context, "The tag is removed from Favorites", Toast.LENGTH_SHORT).show();
                        holder.tagBt.setBackgroundResource(android.R.drawable.btn_default);
                        //holder.tagBt.setVisibility(View.GONE);
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return resultsTags.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        @BindView(R.id.tagButton) Button tagBt;
        private ItemClickListener itemClickListener;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            tagBt.setOnClickListener(this);
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
