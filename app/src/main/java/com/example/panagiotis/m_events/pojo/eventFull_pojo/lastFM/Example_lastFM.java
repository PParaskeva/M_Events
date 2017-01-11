package com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example_lastFM {

    @SerializedName("topartists")
    @Expose
    private Topartists topartists;

    public Topartists getTopartists() {
        return topartists;
    }

    public void setTopartists(Topartists topartists) {
        this.topartists = topartists;
    }

}

