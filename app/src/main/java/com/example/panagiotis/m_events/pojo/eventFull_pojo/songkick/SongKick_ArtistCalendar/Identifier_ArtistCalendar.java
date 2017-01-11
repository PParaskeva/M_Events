package com.example.panagiotis.m_events.pojo.eventFull_pojo.songkick.SongKick_ArtistCalendar;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Identifier_ArtistCalendar {

    @SerializedName("mbid")
    @Expose
    private String mbid;
    @SerializedName("href")
    @Expose
    private String href;

    public String getMbid() {
        return mbid;
    }

    public void setMbid(String mbid) {
        this.mbid = mbid;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

}

