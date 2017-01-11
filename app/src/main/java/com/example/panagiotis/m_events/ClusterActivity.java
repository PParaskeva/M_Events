package com.example.panagiotis.m_events;

import com.example.panagiotis.m_events.Fragments.MapsActivity;
import com.example.panagiotis.m_events.Realm_Models.SongKick.SongKick_Event_Realm;
import com.example.panagiotis.m_events.Realm_Models.location_Realm;
import com.example.panagiotis.m_events.getSongKickData.IContract_GetSoncKick;
import com.example.panagiotis.m_events.getSongKickData.SongKick_Presenter;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.songkick.Example_songkick;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterManager;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Panagiotis on 06/01/2017.
 */

public class ClusterActivity extends MapsActivity implements IContract_GetSoncKick.IView_SongKick {
    private ClusterManager<MyItem> clusterManager;
    private Realm realm;
    private IContract_GetSoncKick.IPresenter_SongKick iPresenter_songKick;


    @Override
    protected void startDemo() {
        realm = Realm.getDefaultInstance();
        RealmResults<location_Realm> resultsLocation = realm.where(location_Realm.class).findAll();
        iPresenter_songKick=new SongKick_Presenter(this);
        getMap().addMarker(new MarkerOptions().position(
                new LatLng(resultsLocation.get(0).getLat(),resultsLocation.get(0).getLot()))
                .title("Me")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
        );
        getMap().moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(resultsLocation.get(0).getLat(),resultsLocation.get(0).getLot()),10));
        clusterManager = new ClusterManager<MyItem>(this, getMap());
        getMap().setOnCameraIdleListener(clusterManager);
        getMap().setOnMarkerClickListener(clusterManager);
        iPresenter_songKick.getEventsNextToMe("geo:"+resultsLocation.get(0).getLat()+","+resultsLocation.get(0).getLot());
        readItems();

    }

    private void readItems() {
        List<MyItem> items = new ArrayList<MyItem>();

        realm = Realm.getDefaultInstance();
        RealmResults<SongKick_Event_Realm> results = realm.where(SongKick_Event_Realm.class).findAll();
        for (int i=0;i<results.size();i++) {
            double lat=results.get(i).getLatitude();
            double lot=results.get(i).getLongitude();
            String eventName=results.get(i).getEventName();
            String venuName=results.get(i).getVenueName();

            //items.add(new MyItem(lat,lot,eventName,venuName));
            clusterManager.addItem(new MyItem(lat,lot,eventName,venuName));

        }
    }

    @Override
    public void displayEventsNextToMe(Example_songkick example_songkick) {

    }


    @Override
    public void setPresenter(IContract_GetSoncKick.IPresenter_SongKick presenter) {
        this.iPresenter_songKick=checkNotNull(presenter);
    }

    @Override
    public void onResume() {
        super.onResume();
        //iPresenter_songKick.start();
    }
}
