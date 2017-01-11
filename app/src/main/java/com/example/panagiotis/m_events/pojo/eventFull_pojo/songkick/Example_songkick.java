package com.example.panagiotis.m_events.pojo.eventFull_pojo.songkick;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example_songkick {

    @SerializedName("resultsPage")
    @Expose
    private ResultsPage_songkick resultsPage;

    public ResultsPage_songkick getResultsPage() {
        return resultsPage;
    }

    public void setResultsPage(ResultsPage_songkick resultsPage) {
        this.resultsPage = resultsPage;
    }

}

