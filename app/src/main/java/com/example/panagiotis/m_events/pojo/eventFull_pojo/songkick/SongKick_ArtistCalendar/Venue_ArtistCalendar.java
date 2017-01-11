package com.example.panagiotis.m_events.pojo.eventFull_pojo.songkick.SongKick_ArtistCalendar;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Venue_ArtistCalendar {

    @SerializedName("lng")
    @Expose
    private Double lng;
    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("uri")
    @Expose
    private String uri;
    @SerializedName("metroArea")
    @Expose
    private MetroArea_ArtistCalendar metroArea;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("lat")
    @Expose
    private Double lat;

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

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

    public MetroArea_ArtistCalendar getMetroArea() {
        return metroArea;
    }

    public void setMetroArea(MetroArea_ArtistCalendar metroArea) {
        this.metroArea = metroArea;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

}
