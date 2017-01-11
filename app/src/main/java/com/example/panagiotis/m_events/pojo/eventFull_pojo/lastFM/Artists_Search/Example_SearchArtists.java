package com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.Artists_Search;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example_SearchArtists {

    @SerializedName("results")
    @Expose
    private Results_SearchArtists results;

    public Results_SearchArtists getResults() {
        return results;
    }

    public void setResults(Results_SearchArtists results) {
        this.results = results;
    }

}
