package com.example.panagiotis.m_events.Services.eventFull;

import com.example.panagiotis.m_events.Constants.Constants;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.Events;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Panagiotis on 31/12/2016.
 */

public interface IData_EventFull {
//http://api.eventful.com/json/events/search?...&location=51.5033640,-0.1276250,%20United%20Kingdom&category=Concerts%20&amp;%20Tour%20Dates&app_key=2CgX4rCk9hVKrFt6
    @GET(Constants.Relative_EventFull_Events)
    Observable<Events> getEvents(@Query("location") String location,
                                 @Query("app_key") String app_key);
}
