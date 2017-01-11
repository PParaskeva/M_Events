package com.example.panagiotis.m_events.pojo.eventFull_pojo.songkick.SongKick_ArtistCalendar;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MetroArea_ArtistCalendar {

    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("uri")
    @Expose
    private String uri;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("state")
    @Expose
    private State_ArtistCalendar state;
    @SerializedName("country")
    @Expose
    private Country_ArtistCalendar country;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public State_ArtistCalendar getState() {
        return state;
    }

    public void setState(State_ArtistCalendar state) {
        this.state = state;
    }

    public Country_ArtistCalendar getCountry() {
        return country;
    }

    public void setCountry(Country_ArtistCalendar country) {
        this.country = country;
    }

}

