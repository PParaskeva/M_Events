package com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.Track_search;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example_SearchTrack {

    @SerializedName("results")
    @Expose
    private Results_SearchTrack results;

    public Results_SearchTrack getResults() {
        return results;
    }

    public void setResults(Results_SearchTrack results) {
        this.results = results;
    }

    public Example_SearchTrack withResults(Results_SearchTrack results) {
        this.results = results;
        return this;
    }

}
