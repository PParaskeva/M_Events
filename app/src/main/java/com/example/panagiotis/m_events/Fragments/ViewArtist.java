package com.example.panagiotis.m_events.Fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
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
import com.example.panagiotis.m_events.Realm_Models.LastFM_models.Temp_Realm;
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
import io.realm.RealmResults;

import static com.google.common.base.Preconditions.checkNotNull;


public class ViewArtist extends Fragment implements IContract_GetLastFM.IView_DataLastFM {

    private String artist;
    private IContract_GetLastFM.IPresenter_DataLastFM iPresenter_dataLastFM;
    private ProgressDialog pDialog;
    private Realm realm;

    @BindView(R.id.imageView_viewArtist) ImageView viewArtistImage;
    @BindView(R.id.viewArtist_ArtistName) CustomTextView ArtistName;
    @BindView(R.id.viewArtist_bio) TextView viewArtistBio;
    @BindView(R.id.recycleView_viewArtist_tag) RecyclerView viewArtist_tag;
    @BindView(R.id.recycleView_viewArtist_similar) RecyclerView viewArtistSimilar;
    @BindView(R.id.fab) FloatingActionButton fab;

    button_tags_adapter buttonTagsAdapter;
    similar_trags_adaptor similarTragsAdaptor;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iPresenter_dataLastFM=new LastFM_Presenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_view_artist, container, false);
        ButterKnife.bind(this,v);
        Bundle b = getArguments();
        artist=b.getString("artists");
        iPresenter_dataLastFM.getArtistInfo(artist);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realm = Realm.getDefaultInstance();
                RealmResults<Temp_Realm> temp_realms = realm.where(Temp_Realm.class).findAll();
                ((MainActivity)getActivity()).fragment_transfer(new ArtistCalendar(),temp_realms.get(0).getTempID(),temp_realms.get(0).getTempImage());
            }
        });
        return v;
    }

    @Override
    public void displayArtistInfo(Example_ArtistGetInfo example_artistGetInfo) {
        ArtistName.setText(example_artistGetInfo.getArtist().getName());
        viewArtistBio.setText(example_artistGetInfo.getArtist().getBio().getSummary());
        viewArtist_tag.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        viewArtist_tag.setItemAnimator(new DefaultItemAnimator());
        buttonTagsAdapter=new button_tags_adapter(R.layout.buttontags_row,
                example_artistGetInfo,
                false,getActivity());
        viewArtist_tag.setAdapter(buttonTagsAdapter);

        Picasso.with(getActivity())
                .load(example_artistGetInfo.getArtist().getImage().get(3).getText())
                .fit()
                .centerCrop()
                .into(viewArtistImage);

        viewArtistSimilar.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        viewArtistSimilar.setItemAnimator(new DefaultItemAnimator());
        similarTragsAdaptor=new similar_trags_adaptor(R.layout.similar_tracks_row,
                example_artistGetInfo,
                (MainActivity)getActivity(),
                getActivity(),
                false);

        viewArtistSimilar.setAdapter(similarTragsAdaptor);


    }

    @Override
    public void displaySimilarTrack(Example_similarTrack example_similarTrack) {

    }


    @Override
    public void displayTrackInfo(Example_TrackInfo example_trackInfo) {

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
