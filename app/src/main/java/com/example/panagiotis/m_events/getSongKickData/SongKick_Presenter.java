package com.example.panagiotis.m_events.getSongKickData;

import com.example.panagiotis.m_events.Constants.Constants;
import com.example.panagiotis.m_events.Realm_Models.SongKick.SongKick_Artist_Realm;
import com.example.panagiotis.m_events.Realm_Models.SongKick.SongKick_Event_Realm;
import com.example.panagiotis.m_events.Services.songkick.IData_Songkick;
import com.example.panagiotis.m_events.Services.songkick.Songkick_Connection;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.songkick.Example_songkick;

import io.realm.Realm;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SongKick_Presenter implements IContract_GetSoncKick.IPresenter_SongKick {

    IData_Songkick iData_songkick;
    IContract_GetSoncKick.IView_SongKick iView_songKick;
    private Realm realm;

    public SongKick_Presenter(IContract_GetSoncKick.IView_SongKick iView_songKick) {
        this.iView_songKick = iView_songKick;
    }

    @Override
    public void getEventsNextToMe(String location) {
        iData_songkick= Songkick_Connection.getSongKickonnection();
        iData_songkick.GetMusicEventsNearMe(location, Constants.api_key_SongKick)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Example_songkick>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(final Example_songkick example_songkick) {

                        realm = Realm.getDefaultInstance();

                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                realm.delete(SongKick_Event_Realm.class);
                            }
                        });

                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                realm.delete(SongKick_Artist_Realm.class);
                            }
                        });


                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                for(int i=0;i<example_songkick.getResultsPage().getResults().getEvent().size();i++) {
                                    SongKick_Event_Realm songKickEventRealm = realm.createObject(SongKick_Event_Realm.class);
                                    songKickEventRealm.setEventName(example_songkick.getResultsPage().getResults().getEvent().get(i).getDisplayName());
                                    songKickEventRealm.setVenueName(example_songkick.getResultsPage().getResults().getEvent().get(i).getVenue().getDisplayName());
                                    songKickEventRealm.setLatitude(example_songkick.getResultsPage().getResults().getEvent().get(i).getLocation().getLat());
                                    songKickEventRealm.setLongitude(example_songkick.getResultsPage().getResults().getEvent().get(i).getLocation().getLng());
                                }
                            }
                        });

                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                for(int i=0;i<example_songkick.getResultsPage().getResults().getEvent().size();i++) {
                                    for(int j=0;j<example_songkick.getResultsPage().getResults().getEvent().get(i).getPerformance().size();j++){
                                        SongKick_Artist_Realm songKickArtistRealm = realm.createObject(SongKick_Artist_Realm.class);
                                        songKickArtistRealm.setEventName(example_songkick.getResultsPage().getResults().getEvent().get(i).getDisplayName());
                                        songKickArtistRealm.setArtistName(example_songkick.getResultsPage().getResults().getEvent().get(i).getPerformance().get(j).getDisplayName());
                                        songKickArtistRealm.setVenueName(example_songkick.getResultsPage().getResults().getEvent().get(i).getVenue().getDisplayName());
                                    }

                                }
                            }
                        });


                        //iView_songKick.displayEventsNextToMe(example_songkick);

                    }
                });
    }

    @Override
    public void start() {
        iView_songKick.setPresenter(this);
    }
}
