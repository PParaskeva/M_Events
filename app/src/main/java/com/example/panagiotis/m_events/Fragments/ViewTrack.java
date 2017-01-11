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
import android.widget.TextView;

import com.example.panagiotis.m_events.CustomTextView;
import com.example.panagiotis.m_events.MainActivity;
import com.example.panagiotis.m_events.R;
import com.example.panagiotis.m_events.adapters.button_tags_adapter;
import com.example.panagiotis.m_events.adapters.similar_trags_adaptor;
import com.example.panagiotis.m_events.getLastFMData.IContract_GetLastFM;
import com.example.panagiotis.m_events.getLastFMData.LastFM_Presenter;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.Artists_Search.Example_SearchArtists;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.Example_ArtistGetInfo;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.Example_lastFM;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.Example_similarTrack;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.Example_topTracks;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.track_info.Example_TrackInfo;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;

import static com.google.common.base.Preconditions.checkNotNull;

public class ViewTrack extends Fragment implements IContract_GetLastFM.IView_DataLastFM {
    private Realm realm;
    button_tags_adapter adapterButtons;
    similar_trags_adaptor adaptorSimilar;
    private ProgressDialog pDialog;

    @BindView(R.id.ArtistName_viewTrack) CustomTextView artistName;
    @BindView(R.id.trackName_viewTrack) TextView trackName;
    @BindView(R.id.track_summary_ViewTrack) TextView trackSummary;
    @BindView(R.id.viewTrack_imageView) ImageView trackImage;
    @BindView(R.id.recycleView_tags_colmnView)RecyclerView recyclerView_buttons_tags;
    @BindView(R.id.recycleView_similar_artists) RecyclerView recyclerView_similar_tracks;

    private IContract_GetLastFM.IPresenter_DataLastFM iPresenter_dataLastFM;
    private String artist,name,imageURL;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iPresenter_dataLastFM=new LastFM_Presenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.view_track, container, false);
        ButterKnife.bind(this,v);

        Bundle b = getArguments();
        artist=b.getString("artists");
        name=b.getString("name");
        imageURL=b.getString("imageURL");

        iPresenter_dataLastFM.getTrackInfo(artist,name);
        return v;
    }

    @Override
    public void displayTrackInfo(Example_TrackInfo example_trackInfo) {

        trackSummary.setText(example_trackInfo.getTrack().getWiki().getSummary());
        trackName.setText(example_trackInfo.getTrack().getName());
        artistName.setText(example_trackInfo.getTrack().getArtist().getName());


        Picasso.with(getActivity())
                .load(imageURL)
                .fit()
                .centerCrop()
                .into(trackImage);

        recyclerView_buttons_tags.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        recyclerView_buttons_tags.setItemAnimator(new DefaultItemAnimator());
        adapterButtons=new button_tags_adapter(R.layout.buttontags_row,example_trackInfo.getTrack().getToptags().getTag(),getActivity());
        recyclerView_buttons_tags.setAdapter(adapterButtons);
        iPresenter_dataLastFM.getSimilarTrack(artist,name);
    }

    @Override
    public void displaySimilarTrack(Example_similarTrack example_similarTrack) {
        recyclerView_similar_tracks.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        recyclerView_similar_tracks.setItemAnimator(new DefaultItemAnimator());
        adaptorSimilar=new similar_trags_adaptor(R.layout.similar_tracks_row,example_similarTrack,(MainActivity) getActivity(),getActivity());
        recyclerView_similar_tracks.setAdapter(adaptorSimilar);
    }

    @Override
    public void displayArtistInfo(Example_ArtistGetInfo example_artistGetInfo) {

    }


    @Override
    public void displayArtists(Example_lastFM example_lastFM) {

    }

    @Override
    public void desplayTracks(Example_topTracks example_topTracks) {

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
