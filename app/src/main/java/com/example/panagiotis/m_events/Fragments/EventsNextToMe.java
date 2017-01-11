package com.example.panagiotis.m_events.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.panagiotis.m_events.ClusterActivity;
import com.example.panagiotis.m_events.R;
import com.example.panagiotis.m_events.Realm_Models.location_Realm;
import com.example.panagiotis.m_events.getSongKickData.IContract_GetSoncKick;
import com.example.panagiotis.m_events.getSongKickData.SongKick_Presenter;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.songkick.Example_songkick;

import io.realm.Realm;
import io.realm.RealmResults;

import static com.google.common.base.Preconditions.checkNotNull;

public class EventsNextToMe extends Fragment implements IContract_GetSoncKick.IView_SongKick {

    IContract_GetSoncKick.IPresenter_SongKick iPresenter_songKick;
    private Realm realm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iPresenter_songKick=new SongKick_Presenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_events_next_to_me, container, false);
        realm = Realm.getDefaultInstance();
        RealmResults<location_Realm> resultsLocation = realm.where(location_Realm.class).findAll();
        String location="geo:"+resultsLocation.get(0).getLat()+","+resultsLocation.get(0).getLot();
        iPresenter_songKick.getEventsNextToMe(location);
        return v;
    }

    @Override
    public void displayEventsNextToMe(Example_songkick example_songkick) {
        Intent i = new Intent(getActivity(), ClusterActivity.class);
        startActivity(i);
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

}
