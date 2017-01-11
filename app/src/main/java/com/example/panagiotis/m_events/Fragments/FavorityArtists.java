package com.example.panagiotis.m_events.Fragments;

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
import com.example.panagiotis.m_events.Realm_Models.LastFM_models.FavoriteArtists_Realm;
import com.example.panagiotis.m_events.adapters.FavorityArtists_Adaport;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmResults;

public class FavorityArtists extends Fragment {

    @BindView(R.id.FavorityArtists_recycleView) RecyclerView recyclerView_favorityArtists;
    private FavorityArtists_Adaport adaport;
    private Realm realm;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_favority_artists, container, false);
        ButterKnife.bind(this,v);
        displayFavorityArtists();
        return v;
    }

    private void displayFavorityArtists(){
        realm = Realm.getDefaultInstance();
        RealmResults<FavoriteArtists_Realm> resultsFavorityArtists = realm.where(FavoriteArtists_Realm.class).findAll();
        recyclerView_favorityArtists.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView_favorityArtists.setItemAnimator(new DefaultItemAnimator());
        adaport= new FavorityArtists_Adaport(R.layout.favority_artists_row,getActivity(),(MainActivity) getActivity(),resultsFavorityArtists);
        recyclerView_favorityArtists.setAdapter(adaport);
    }


}
