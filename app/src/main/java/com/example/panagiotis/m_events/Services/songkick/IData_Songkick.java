package com.example.panagiotis.m_events.Services.songkick;


import com.example.panagiotis.m_events.Constants.Constants;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.songkick.Example_songkick;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface IData_Songkick {

    @GET(Constants.songKick_extend)
    Observable<Example_songkick> GetMusicEventsNearMe
            (@Query("location") String location,
            @Query("apikey") String apiley);

}
