package com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example_topTracks {

    @SerializedName("tracks")
    @Expose
    private Tracks tracks;

    public Tracks getTracks() {
        return tracks;
    }

    public void setTracks(Tracks tracks) {
        this.tracks = tracks;
    }
}
