package com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example_track_info {

    @SerializedName("track")
    @Expose
    private Track track;

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

}