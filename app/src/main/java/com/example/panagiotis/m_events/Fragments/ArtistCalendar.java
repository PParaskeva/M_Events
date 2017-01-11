package com.example.panagiotis.m_events.Fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.panagiotis.m_events.Constants.Constants;
import com.example.panagiotis.m_events.R;
import com.example.panagiotis.m_events.adapters.artistCalendar_adaptor;
import com.example.panagiotis.m_events.getSongKickData.IContract_GetSoncKick;
import com.example.panagiotis.m_events.getSongKickData.SongKick_Presenter;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.songkick.Example_songkick;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.songkick.SongKick_ArtistCalendar.Example_ArtistCalendar;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.google.common.base.Preconditions.checkNotNull;

public class ArtistCalendar extends Fragment implements IContract_GetSoncKick.IView_SongKick {

    @BindView(R.id.artistCalendar_ImageView) ImageView ArtistCalendaImage;
    @BindView(R.id.ArtistCalendar_recycleView) RecyclerView artistCalendar_recycleView;

    private String artist;
    private String imageUrl;
    private IContract_GetSoncKick.IPresenter_SongKick iPresenter_songKick;
    private ProgressDialog pDialog;
    private artistCalendar_adaptor adaptor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iPresenter_songKick=new SongKick_Presenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_artist_calendar, container, false);
        ButterKnife.bind(this,v);
        Bundle b = getArguments();
        artist=b.getString("ArtistID");
        imageUrl=b.getString("imageURL");
        Picasso.with(getActivity())
                .load(imageUrl)
                .fit()
                .centerCrop()
                .into(ArtistCalendaImage);
        Constants.ArtistMid="artists/mbid:"+artist+"/";
        iPresenter_songKick.getArtistCalendar();
        return v;
    }

    @Override
    public void displayArtistCalendar(Example_ArtistCalendar example_artistCalendar) {
        artistCalendar_recycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        artistCalendar_recycleView.setItemAnimator(new DefaultItemAnimator());
        adaptor= new artistCalendar_adaptor(R.layout.artist_calendar_row,example_artistCalendar,getActivity());
        artistCalendar_recycleView.setAdapter(adaptor);
    }

    @Override
    public void setPresenter(IContract_GetSoncKick.IPresenter_SongKick presenter) {
        this.iPresenter_songKick=checkNotNull(presenter);
    }

    @Override
    public void onResume() {
        super.onResume();
        iPresenter_songKick.start();
    }

    @Override
    public void showProgressDialog() {
        pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.show();
    }

    @Override
    public void dismissProgressDialog() {
        if(pDialog.isShowing() || pDialog!=null){
            pDialog.dismiss();
        }
    }

    @Override
    public void displayEventsNextToMe(Example_songkick example_songkick) {

    }
}
