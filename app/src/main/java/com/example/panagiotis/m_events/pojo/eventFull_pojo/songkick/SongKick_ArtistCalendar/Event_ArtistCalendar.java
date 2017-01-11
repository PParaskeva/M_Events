package com.example.panagiotis.m_events.pojo.eventFull_pojo.songkick.SongKick_ArtistCalendar;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Event_ArtistCalendar {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("ageRestriction")
    @Expose
    private Object ageRestriction;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("performance")
    @Expose
    private List<Performance_ArtistCalendar> performance = null;
    @SerializedName("venue")
    @Expose
    private Venue_ArtistCalendar venue;
    @SerializedName("start")
    @Expose
    private Start_ArtistCalendar start;
    @SerializedName("location")
    @Expose
    private Location_ArtistCalendar location;
    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("uri")
    @Expose
    private String uri;
    @SerializedName("popularity")
    @Expose
    private Double popularity;
    @SerializedName("id")
    @Expose
    private Integer id;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(Object ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Performance_ArtistCalendar> getPerformance() {
        return performance;
    }

    public void setPerformance(List<Performance_ArtistCalendar> performance) {
        this.performance = performance;
    }

    public Venue_ArtistCalendar getVenue() {
        return venue;
    }

    public void setVenue(Venue_ArtistCalendar venue) {
        this.venue = venue;
    }

    public Start_ArtistCalendar getStart() {
        return start;
    }

    public void setStart(Start_ArtistCalendar start) {
        this.start = start;
    }

    public Location_ArtistCalendar getLocation() {
        return location;
    }

    public void setLocation(Location_ArtistCalendar location) {
        this.location = location;
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

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
