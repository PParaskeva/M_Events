package com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attr_similarTrack {

    @SerializedName("artist")
    @Expose
    private String artist;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

}