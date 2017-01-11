package com.example.panagiotis.m_events.pojo.eventFull_pojo.songkick.SongKick_ArtistCalendar;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Country_ArtistCalendar {

    @SerializedName("displayName")
    @Expose
    private String displayName;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

}
