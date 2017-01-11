package com.example.panagiotis.m_events.Constants;

/**
 * Created by Panagiotis on 31/12/2016.
 */

public class Constants {
    //http://api.eventful.com/json/events/search
    // ?...&location=San%20Diego&app_key=2CgX4rCk9hVKrFt6

    public static final String BASE_EventFull_URL=
            "http://api.eventful.com/";

    public static final String Relative_EventFull_Events="" +
            "json/events/";

    public static final String BASE_LastFM_URL="http://ws.audioscrobbler.com/2.0/";

    public static final String BASE_SongKick_URL="http://api.songkick.com/api/3.0/";
    public static final String songKick_extend="events.json";

    public static final String lastFM_method_geo_gettopartists="geo.gettopartists";
    public static final String lastFM_method_trackInfo="track.getInfo";
    public static final String lastFM_method_geo_gettoptracks="geo.gettoptracks";
    public static final String lastFM_method_similarTracks="track.getsimilar";
    public static final String lastFM_method_artistInfo="artist.getinfo";
    public static final String lastFM_method_artistSearch="artist.search";

    public static final String last_fm_limit="5";
    public static final String file_format="json";
    public static final String api_key_lastFM="25e495c4de95a5cdfa75bde764cf37f2";

    public static final String api_key_SongKick="RSK2Ccn5zSk4OIDN";



}
