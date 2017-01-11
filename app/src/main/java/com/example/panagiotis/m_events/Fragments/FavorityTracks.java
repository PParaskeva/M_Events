package com.example.panagiotis.m_events.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.panagiotis.m_events.MainActivity;
import com.example.panagiotis.m_events.R;
import com.example.panagiotis.m_events.Realm_Models.LastFM_models.FavotiteTracks_Realm;
import com.example.panagiotis.m_events.adapters.FavorityTracks_adaptor;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmResults;

public class FavorityTracks extends Fragment {

    @BindView(R.id.FavorityTracks_recycleView) RecyclerView FavorityTracksrecyclerView;
    private FavorityTracks_adaptor adaptor;
    private Realm realm;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_favority_tracks, container, false);
        ButterKnife.bind(this,v);
        displayFavorityTracks();
        return v;
    }

    public void displayFavorityTracks(){
        realm = Realm.getDefaultInstance();
        RealmResults<FavotiteTracks_Realm> resultsFavorityTracks = realm.where(FavotiteTracks_Realm.class).findAll();
        if(resultsFavorityTracks.size()!=0) {
            FavorityTracksrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            FavorityTracksrecyclerView.setItemAnimator(new DefaultItemAnimator());
            adaptor = new FavorityTracks_adaptor(R.layout.favority_tracks_row, getActivity(), (MainActivity) getActivity(), resultsFavorityTracks);
            FavorityTracksrecyclerView.setAdapter(adaptor);
        }
        else {
            Toast.makeText(getActivity(), "No tracks to show", Toast.LENGTH_SHORT).show();
        }
    }

}
