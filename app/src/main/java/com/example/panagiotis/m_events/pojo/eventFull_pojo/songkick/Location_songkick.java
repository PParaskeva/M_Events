package com.example.panagiotis.m_events.pojo.eventFull_pojo.songkick;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location_songkick {

    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("lng")
    @Expose
    private Double lng;
    @SerializedName("city")
    @Expose
    private String city;

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
