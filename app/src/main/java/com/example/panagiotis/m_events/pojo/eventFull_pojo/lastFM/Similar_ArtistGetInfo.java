package com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Similar_ArtistGetInfo {

    @SerializedName("artist")
    @Expose
    private List<Artist_sim_ArtistGetInfo> artist = null;

    public List<Artist_sim_ArtistGetInfo> getArtist() {
        return artist;
    }

    public void setArtist(List<Artist_sim_ArtistGetInfo> artist) {
        this.artist = artist;
    }

}
