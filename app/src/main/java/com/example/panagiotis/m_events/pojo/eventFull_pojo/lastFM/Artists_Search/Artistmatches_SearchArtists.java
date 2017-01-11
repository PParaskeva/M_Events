package com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.Artists_Search;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Artistmatches_SearchArtists {

    @SerializedName("artist")
    @Expose
    private List<Artist_SearchArtists> artist = null;

    public List<Artist_SearchArtists> getArtist() {
        return artist;
    }

    public void setArtist(List<Artist_SearchArtists> artist) {
        this.artist = artist;
    }

}
