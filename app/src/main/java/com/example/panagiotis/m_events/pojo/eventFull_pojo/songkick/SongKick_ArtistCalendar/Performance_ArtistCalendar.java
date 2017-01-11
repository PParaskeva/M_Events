package com.example.panagiotis.m_events.pojo.eventFull_pojo.songkick.SongKick_ArtistCalendar;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Performance_ArtistCalendar {

    @SerializedName("billingIndex")
    @Expose
    private Integer billingIndex;
    @SerializedName("billing")
    @Expose
    private String billing;
    @SerializedName("artist")
    @Expose
    private Artist_ArtistCalendar artist;
    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("id")
    @Expose
    private Integer id;

    public Integer getBillingIndex() {
        return billingIndex;
    }

    public void setBillingIndex(Integer billingIndex) {
        this.billingIndex = billingIndex;
    }

    public String getBilling() {
        return billing;
    }

    public void setBilling(String billing) {
        this.billing = billing;
    }

    public Artist_ArtistCalendar getArtist() {
        return artist;
    }

    public void setArtist(Artist_ArtistCalendar artist) {
        this.artist = artist;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
