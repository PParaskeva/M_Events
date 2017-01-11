package com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.Track_search;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OpensearchQuery_SearchTrack {

    @SerializedName("#text")
    @Expose
    private String text;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("startPage")
    @Expose
    private String startPage;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public OpensearchQuery_SearchTrack withText(String text) {
        this.text = text;
        return this;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public OpensearchQuery_SearchTrack withRole(String role) {
        this.role = role;
        return this;
    }

    public String getStartPage() {
        return startPage;
    }

    public void setStartPage(String startPage) {
        this.startPage = startPage;
    }

    public OpensearchQuery_SearchTrack withStartPage(String startPage) {
        this.startPage = startPage;
        return this;
    }

}
