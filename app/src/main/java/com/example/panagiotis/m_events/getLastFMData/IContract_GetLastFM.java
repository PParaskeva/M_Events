package com.example.panagiotis.m_events.getLastFMData;

import com.example.panagiotis.m_events.MVP.BasedPresenter;
import com.example.panagiotis.m_events.MVP.BasedView;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.Artists_Search.Example_SearchArtists;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.Example_ArtistGetInfo;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.Example_lastFM;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.Example_similarTrack;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.Example_topTracks;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.track_info.Example_TrackInfo;

/**
 * Created by Panagiotis on 22/12/2016.
 */

public interface IContract_GetLastFM {
    public interface IPresenter_DataLastFM extends BasedPresenter{

        public void getToptracks();
        public void getTopArtists();
        public void getTrackInfo(String artist,String name);
        public void getSimilarTrack(String artist, String name);
        public void getArtistInfo(String id);
        public void searchTrack(String track);
        public void searchArtists(String artists);
    }

    public interface IView_DataLastFM extends BasedView<IPresenter_DataLastFM>{

        public void displayArtists(Example_lastFM example_lastFM);
        public void desplayTracks(Example_topTracks example_topTracks);
        public void displayTrackInfo(Example_TrackInfo example_trackInfo);
        public void displaySimilarTrack(Example_similarTrack example_similarTrack);
        public void displayArtistInfo(Example_ArtistGetInfo example_artistGetInfo);
        public void showProgressDialog();
        public void dismissProgressDialog();
        public void displayTrack();
        public void displaySearchArtists(Example_SearchArtists example_searchArtists);
    }
}
