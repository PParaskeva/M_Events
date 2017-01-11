package com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.Track_search;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Trackmatches_SearchTrack {

    @SerializedName("track")
    @Expose
    private List<Track_SearchTrack> track = null;

    public List<Track_SearchTrack> getTrack() {
        return track;
    }

    public void setTrack(List<Track_SearchTrack> track) {
        this.track = track;
    }

    public Trackmatches_SearchTrack withTrack(List<Track_SearchTrack> track) {
        this.track = track;
        return this;
    }

}
