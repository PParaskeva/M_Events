package com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example_similarTrack {

    @SerializedName("similartracks")
    @Expose
    private Similartracks similartracks;

    public Similartracks getSimilartracks() {
        return similartracks;
    }

    public void setSimilartracks(Similartracks similartracks) {
        this.similartracks = similartracks;
    }

}