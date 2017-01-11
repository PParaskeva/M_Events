package com.example.panagiotis.m_events.Services.LastFM;

import com.example.panagiotis.m_events.Constants.Constants;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.Artists_Search.Example_SearchArtists;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.Example_ArtistGetInfo;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.Example_lastFM;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.Example_similarTrack;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.Example_topTracks;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.track_info.Example_TrackInfo;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


public interface IData_LastFM {

    @GET(Constants.BASE_LastFM_URL)
    Observable<Example_lastFM> getLocationTopArtists
            (@Query("method") String method,
             @Query("country") String country,
             @Query("api_key") String api_key,
             @Query("format") String format);

    @GET(Constants.BASE_LastFM_URL)
    Observable<Example_topTracks> getLocationTopTracks
            (@Query("method") String method,
             @Query("country") String country,
             @Query("api_key") String api_key,
             @Query("format") String format);

    @GET(Constants.BASE_LastFM_URL)
    Observable<Example_TrackInfo> getTrackInfoAPI
            (@Query("method") String method,
             @Query("api_key") String api_key,
             @Query("artist") String artist,
             @Query("track") String track,
             @Query("format") String format);


    @GET(Constants.BASE_LastFM_URL)
    Observable<Example_similarTrack> getSimilarTrackAPI
            (@Query("method") String method,
             @Query("artist") String artist,
             @Query("track") String track,
             @Query("api_key") String api_key,
             @Query("format") String format
            );
    @GET(Constants.BASE_LastFM_URL)
    Observable<Example_ArtistGetInfo> getArtistInfoAPI
            (@Query("method") String method,
             @Query("artist") String artist,
             @Query("api_key") String api_key,
             @Query("format") String format);

    @GET(Constants.BASE_LastFM_URL)
    Observable<Example_SearchArtists> getArtistSearch
            (@Query("method") String method,
             @Query("limit") String limit,
             @Query("artist") String artist,
             @Query("api_key") String api_key,
             @Query("format") String format
             );
}
