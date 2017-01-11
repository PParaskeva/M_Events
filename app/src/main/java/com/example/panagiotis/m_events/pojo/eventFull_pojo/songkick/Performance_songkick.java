package com.example.panagiotis.m_events.pojo.eventFull_pojo.songkick;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Performance_songkick {

    @SerializedName("billing")
    @Expose
    private String billing;
    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("billingIndex")
    @Expose
    private Integer billingIndex;
    @SerializedName("artist")
    @Expose
    private Artist_songkick artist;
    @SerializedName("id")
    @Expose
    private Integer id;

    public String getBilling() {
        return billing;
    }

    public void setBilling(String billing) {
        this.billing = billing;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Integer getBillingIndex() {
        return billingIndex;
    }

    public void setBillingIndex(Integer billingIndex) {
        this.billingIndex = billingIndex;
    }

    public Artist_songkick getArtist() {
        return artist;
    }

    public void setArtist(Artist_songkick artist) {
        this.artist = artist;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
