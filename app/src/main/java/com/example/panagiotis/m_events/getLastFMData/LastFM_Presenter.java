package com.example.panagiotis.m_events.getLastFMData;

import com.example.panagiotis.m_events.Constants.Constants;
import com.example.panagiotis.m_events.Realm_Models.location_Realm;
import com.example.panagiotis.m_events.Services.LastFM.IData_LastFM;
import com.example.panagiotis.m_events.Services.LastFM.LastFM_Connection;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.Artists_Search.Example_SearchArtists;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.Example_ArtistGetInfo;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.Example_lastFM;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.Example_similarTrack;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.Example_topTracks;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.track_info.Example_TrackInfo;

import io.realm.Realm;
import io.realm.RealmResults;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class LastFM_Presenter implements IContract_GetLastFM.IPresenter_DataLastFM{
    IData_LastFM iData_lastFM;
    IContract_GetLastFM.IView_DataLastFM iView_dataLastFM;

    private Realm realm;

    public LastFM_Presenter(IContract_GetLastFM.IView_DataLastFM iView_dataLastFM){
        this.iView_dataLastFM=iView_dataLastFM;
    }


    @Override
    public void getToptracks() {
        iView_dataLastFM.showProgressDialog();
        realm = Realm.getDefaultInstance();
        RealmResults<location_Realm> resultsLocation = realm.where(location_Realm.class).findAll();
        iData_lastFM=LastFM_Connection.getLastFMConnection();
        iData_lastFM.getLocationTopTracks(Constants.lastFM_method_geo_gettoptracks,resultsLocation.get(0).getCountry(),
                Constants.api_key_lastFM,Constants.file_format)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Example_topTracks>() {
                    @Override
                    public void onCompleted() {
                        iView_dataLastFM.dismissProgressDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        iView_dataLastFM.dismissProgressDialog();
                    }

                    @Override
                    public void onNext(Example_topTracks example_topTracks) {
                        iView_dataLastFM.desplayTracks(example_topTracks);
                    }
                });
    }

    @Override
    public void getSimilarTrack(String artist, String name) {
        iView_dataLastFM.showProgressDialog();
        iData_lastFM=LastFM_Connection.getLastFMConnection();
        iData_lastFM.getSimilarTrackAPI(Constants.lastFM_method_similarTracks,artist,name,
                Constants.api_key_lastFM,Constants.file_format)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Example_similarTrack>() {
                    @Override
                    public void onCompleted() {
                        iView_dataLastFM.dismissProgressDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        iView_dataLastFM.dismissProgressDialog();
                    }

                    @Override
                    public void onNext(Example_similarTrack example_similarTrack) {
                        iView_dataLastFM.displaySimilarTrack(example_similarTrack);
                    }
                });
    }

    @Override
    public void getArtistInfo(String artist) {
        iView_dataLastFM.showProgressDialog();
        iData_lastFM=LastFM_Connection.getLastFMConnection();
        iData_lastFM.getArtistInfoAPI(Constants.lastFM_method_artistInfo,artist,Constants.api_key_lastFM,Constants.file_format)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Example_ArtistGetInfo>() {
                    @Override
                    public void onCompleted() {
                        iView_dataLastFM.dismissProgressDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        iView_dataLastFM.dismissProgressDialog();
                    }

                    @Override
                    public void onNext(Example_ArtistGetInfo example_artistGetInfo) {
                        iView_dataLastFM.displayArtistInfo(example_artistGetInfo);
                    }
                });
    }

    @Override
    public void getTrackInfo(String artist,String name) {
        iView_dataLastFM.showProgressDialog();
        iData_lastFM=LastFM_Connection.getLastFMConnection();
        iData_lastFM.getTrackInfoAPI(Constants.lastFM_method_trackInfo,Constants.api_key_lastFM,artist,name,Constants.file_format)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Example_TrackInfo>() {
                    @Override
                    public void onCompleted() {
                        iView_dataLastFM.dismissProgressDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        iView_dataLastFM.dismissProgressDialog();
                    }

                    @Override
                    public void onNext(Example_TrackInfo example_trackInfo) {
                        iView_dataLastFM.displayTrackInfo(example_trackInfo);
                    }

                });
    }

    @Override
    public void searchTrack(String track) {
    }

    @Override
    public void searchArtists(String artists) {
        iView_dataLastFM.showProgressDialog();
        iData_lastFM=LastFM_Connection.getLastFMConnection();
        iData_lastFM.getArtistSearch(Constants.lastFM_method_artistSearch,
                Constants.last_fm_limit,artists,Constants.api_key_lastFM,Constants.file_format)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Example_SearchArtists>() {
                    @Override
                    public void onCompleted() {
                        iView_dataLastFM.dismissProgressDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        iView_dataLastFM.dismissProgressDialog();
                    }

                    @Override
                    public void onNext(Example_SearchArtists example_searchArtists) {
                        iView_dataLastFM.displaySearchArtists(example_searchArtists);
                    }
                });
    }
    @Override
    public void getTopArtists() {
        iView_dataLastFM.showProgressDialog();
        realm = Realm.getDefaultInstance();
        RealmResults<location_Realm> resultsLocation = realm.where(location_Realm.class).findAll();
        iData_lastFM= LastFM_Connection.getLastFMConnection();
        iData_lastFM.getLocationTopArtists(Constants.lastFM_method_geo_gettopartists,resultsLocation.get(0).getCountry(),
                Constants.api_key_lastFM,Constants.file_format)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Example_lastFM>() {
                    @Override
                    public void onCompleted() {
                        iView_dataLastFM.dismissProgressDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        iView_dataLastFM.dismissProgressDialog();
                    }

                    @Override
                    public void onNext(Example_lastFM example_lastFM) {
                        iView_dataLastFM.displayArtists(example_lastFM);
                    }
                });
    }




    @Override
    public void start() {
        iView_dataLastFM.setPresenter(this);
    }
}
