package com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.track_info;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attr_TrackInfo {

    @SerializedName("position")
    @Expose
    private String position;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

}
