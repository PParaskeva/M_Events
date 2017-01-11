package com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example_ArtistGetInfo {

    @SerializedName("artist")
    @Expose
    private Artist_ArtistGetInfo artist;

    public Artist_ArtistGetInfo getArtist() {
        return artist;
    }

    public void setArtist(Artist_ArtistGetInfo artist) {
        this.artist = artist;
    }

}