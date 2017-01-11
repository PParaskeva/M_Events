package com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.Track_search;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image_SearchTrack {

    @SerializedName("#text")
    @Expose
    private String text;
    @SerializedName("size")
    @Expose
    private String size;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Image_SearchTrack withText(String text) {
        this.text = text;
        return this;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Image_SearchTrack withSize(String size) {
        this.size = size;
        return this;
    }

}
