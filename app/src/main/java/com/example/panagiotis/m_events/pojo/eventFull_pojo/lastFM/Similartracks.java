package com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Similartracks {

    @SerializedName("track")
    @Expose
    private List<Track_similarTrack> track = null;
    @SerializedName("@attr")
    @Expose
    private Attr_similarTrack attr;

    public List<Track_similarTrack> getTrack() {
        return track;
    }

    public void setTrack(List<Track_similarTrack> track) {
        this.track = track;
    }

    public Attr_similarTrack getAttr() {
        return attr;
    }

    public void setAttr(Attr_similarTrack attr) {
        this.attr = attr;
    }

}