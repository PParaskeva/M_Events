package com.example.panagiotis.m_events.pojo.eventFull_pojo.songkick;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientLocation_songkick {

    @SerializedName("ip")
    @Expose
    private Object ip;
    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("lng")
    @Expose
    private Double lng;
    @SerializedName("metroAreaId")
    @Expose
    private Integer metroAreaId;

    public Object getIp() {
        return ip;
    }

    public void setIp(Object ip) {
        this.ip = ip;
    }

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

    public Integer getMetroAreaId() {
        return metroAreaId;
    }

    public void setMetroAreaId(Integer metroAreaId) {
        this.metroAreaId = metroAreaId;
    }

}
