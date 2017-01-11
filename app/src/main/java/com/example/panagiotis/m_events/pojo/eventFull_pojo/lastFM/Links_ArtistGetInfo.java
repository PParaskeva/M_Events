package com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links_ArtistGetInfo {

    @SerializedName("link")
    @Expose
    private Link_ArtistGetInfo link;

    public Link_ArtistGetInfo getLink() {
        return link;
    }

    public void setLink(Link_ArtistGetInfo link) {
        this.link = link;
    }

}
