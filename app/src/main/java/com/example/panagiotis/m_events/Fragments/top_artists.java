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

import com.example.panagiotis.m_events.MainActivity;
import com.example.panagiotis.m_events.R;
import com.example.panagiotis.m_events.adapters.top_artists_adapter;
import com.example.panagiotis.m_events.getLastFMData.IContract_GetLastFM;
import com.example.panagiotis.m_events.getLastFMData.LastFM_Presenter;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.Artists_Search.Example_SearchArtists;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.Example_ArtistGetInfo;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.Example_lastFM;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.Example_similarTrack;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.Example_topTracks;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.track_info.Example_TrackInfo;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.google.common.base.Preconditions.checkNotNull;

public class top_artists extends Fragment implements IContract_GetLastFM.IView_DataLastFM {


    private top_artists_adapter adaptor;
    @BindView(R.id.top_artists_recycleView) RecyclerView recyclerView;
    private IContract_GetLastFM.IPresenter_DataLastFM iPresenter_dataLastFM;
    private ProgressDialog pDialog;

    public top_artists() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iPresenter_dataLastFM=new LastFM_Presenter(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_top_artists, container, false);
        ButterKnife.bind(this,v);
        iPresenter_dataLastFM.getTopArtists();
        return v;
    }

    @Override
    public void displayArtists(Example_lastFM example_lastFM) {

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adaptor= new top_artists_adapter(R.layout.top_artists_column,example_lastFM,getActivity(),(MainActivity) getActivity());
        recyclerView.setAdapter(adaptor);
    }

    @Override
    public void desplayTracks(Example_topTracks example_topTracks) {

    }


    @Override
    public void displayTrackInfo(Example_TrackInfo example_trackInfo) {

    }

    @Override
    public void displaySimilarTrack(Example_similarTrack example_similarTrack) {

    }

    @Override
    public void displayArtistInfo(Example_ArtistGetInfo example_artistGetInfo) {

    }

    @Override
    public void setPresenter(IContract_GetLastFM.IPresenter_DataLastFM presenter) {
        this.iPresenter_dataLastFM=checkNotNull(presenter);
    }

    @Override
    public void onResume() {
        super.onResume();
        iPresenter_dataLastFM.start();
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
    public void displayTrack() {

    }

    @Override
    public void displaySearchArtists(Example_SearchArtists example_searchArtists) {

    }

}
