package com.example.panagiotis.m_events.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.panagiotis.m_events.Fragments.ViewArtist;
import com.example.panagiotis.m_events.Fragments.ViewTrack;
import com.example.panagiotis.m_events.MainActivity;
import com.example.panagiotis.m_events.R;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.Example_ArtistGetInfo;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.Example_similarTrack;
import com.example.panagiotis.m_events.utils.ItemClickListener;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Panagiotis on 03/01/2017.
 */

public class similar_trags_adaptor extends RecyclerView.Adapter<similar_trags_adaptor.ViewHolder> {
    private int row;
    private Example_similarTrack example_similarTrack;
    private Example_ArtistGetInfo example_artistGetInfo;
    private boolean check=true;
    private MainActivity mainActivity;
    private Context context;

    public similar_trags_adaptor(int row, Example_similarTrack example_similarTrack, MainActivity mainActivity, Context context) {
        this.row = row;
        this.example_similarTrack = example_similarTrack;
        this.mainActivity = mainActivity;
        this.context = context;
    }

    public similar_trags_adaptor(int row, Example_ArtistGetInfo example_artistGetInfo, MainActivity mainActivity, Context context, boolean check) {
        this.row = row;
        this.example_artistGetInfo=example_artistGetInfo;
        this.mainActivity = mainActivity;
        this.context = context;
        this.check=check;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(row,parent,false);
        return new similar_trags_adaptor.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        if(check){
            Picasso.with(context)
                    .load(example_similarTrack.getSimilartracks().getTrack().get(position).getImage().get(3).getText())
                    .resize(164, 164)
                    .centerCrop()
                    .into(holder.similarSong_image);
            holder.similarSong_name.setText(example_similarTrack.getSimilartracks().getTrack().get(position).getName());
        }
        else {
            Picasso.with(context)
                    .load(example_artistGetInfo.getArtist().getSimilar().getArtist().get(position).getImage().get(3).getText())
                    .resize(164, 164)
                    .centerCrop()
                    .into(holder.similarSong_image);

            holder.similarSong_name.setText(example_artistGetInfo.getArtist().getSimilar().getArtist().get(position).getName());
        }

        holder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if(!isLongClick && check){
                    mainActivity.fragment_transfer(new ViewTrack(),
                            example_similarTrack.getSimilartracks().getTrack().get(position).getArtist().getName(),
                            example_similarTrack.getSimilartracks().getTrack().get(position).getName(),
                            example_similarTrack.getSimilartracks().getTrack().get(position).getImage().get(3).getText());
                }
                else {
                    mainActivity.fragment_transfer(new ViewArtist(),
                            example_artistGetInfo.getArtist().getSimilar().getArtist().get(position).getName());
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        int temp=0;
        if(check){
            temp=example_similarTrack.getSimilartracks().getTrack().size();
        }
        else {
            temp=example_artistGetInfo.getArtist().getSimilar().getArtist().size();
        }
        return temp;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        @BindView(R.id.similarTrack_textView) TextView similarSong_name;
        @BindView(R.id.similarTrack_imageView) ImageView similarSong_image;
        @BindView(R.id.similarTrack_linearLayout) LinearLayout linearLayout;
        private ItemClickListener itemClickListener;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
//            similarSong_name=(TextView) itemView.findViewById(R.id.similarTrack_textView);
//            similarSong_image=(ImageView) itemView.findViewById(R.id.similarTrack_imageView);
//            linearLayout=(LinearLayout) itemView.findViewById(R.id.similarTrack_linearLayout);
            linearLayout.setOnClickListener(this);
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
