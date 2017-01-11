package com.example.panagiotis.m_events.Fragments;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.panagiotis.m_events.MainActivity;
import com.example.panagiotis.m_events.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import io.realm.Realm;

public abstract class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    MainActivity mainActivity;
    private Realm realm;
    private boolean check=true;

    protected int getLayoutId() {
        return R.layout.activity_maps;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        setUpMap();
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        mMap = googleMap;
//        mainActivity=new MainActivity();
//
//        realm = Realm.getDefaultInstance();
//        RealmResults<SongKick_Event_Realm> results = realm.where(SongKick_Event_Realm.class).findAll();
//        for (int i=0;i<results.size();i++) {
//            double lat=results.get(i).getLatitude();
//            double lot=results.get(i).getLongitude();
//            String eventName=results.get(i).getEventName();
//            String venuName=results.get(i).getVenueName();
//
//            mMap.addMarker(new MarkerOptions().position(new LatLng(lat,lot)).title(eventName));
//        }
//        RealmResults<location_Realm> resultsLocation = realm.where(location_Realm.class).findAll();

//        mMap.addMarker(new MarkerOptions().position(
//                new LatLng(resultsLocation.get(0).getLat(),resultsLocation.get(0).getLot()))
//                .title("Me")
//                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
//        );
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(resultsLocation.get(0).getLat(),resultsLocation.get(0).getLot()),10));


        //RealmResults<SongKick_Artist_Realm> results = realm.where(SongKick_Artist_Realm.class).equalTo("EventName", ).findAll();
//
//    }
    @Override
    protected void onResume() {
        super.onResume();
        setUpMap();
    }

    @Override
    public void onMapReady(GoogleMap map) {
        if (mMap != null) {
            return;
        }
        mMap = map;
        startDemo();
    }
    private void setUpMap() {
        ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMapAsync(this);
    }

    protected abstract void startDemo();

    protected GoogleMap getMap() {
        return mMap;
    }
}
