package com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.track_info;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example_TrackInfo {

    @SerializedName("track")
    @Expose
    private Track_TrackInfo track;

    public Track_TrackInfo getTrack() {
        return track;
    }

    public void setTrack(Track_TrackInfo track) {
        this.track = track;
    }

}
