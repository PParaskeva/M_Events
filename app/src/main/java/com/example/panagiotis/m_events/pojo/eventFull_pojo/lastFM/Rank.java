package com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM;


import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class Rank {

    @SerializedName("rank")
    @Expose
    private String rank;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

}