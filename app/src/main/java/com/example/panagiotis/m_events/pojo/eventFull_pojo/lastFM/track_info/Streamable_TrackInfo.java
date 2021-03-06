package com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.track_info;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Streamable_TrackInfo {

    @SerializedName("#text")
    @Expose
    private String text;
    @SerializedName("fulltrack")
    @Expose
    private String fulltrack;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFulltrack() {
        return fulltrack;
    }

    public void setFulltrack(String fulltrack) {
        this.fulltrack = fulltrack;
    }

}
