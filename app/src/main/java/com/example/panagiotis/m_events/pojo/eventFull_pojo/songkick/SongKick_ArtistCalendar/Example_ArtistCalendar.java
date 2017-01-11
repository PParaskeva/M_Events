package com.example.panagiotis.m_events.pojo.eventFull_pojo.songkick.SongKick_ArtistCalendar;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example_ArtistCalendar {

    @SerializedName("resultsPage")
    @Expose
    private ResultsPage_ArtistCalendar resultsPage;

    public ResultsPage_ArtistCalendar getResultsPage() {
        return resultsPage;
    }

    public void setResultsPage(ResultsPage_ArtistCalendar resultsPage) {
        this.resultsPage = resultsPage;
    }

}

