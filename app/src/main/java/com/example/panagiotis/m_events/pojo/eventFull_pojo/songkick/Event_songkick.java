package com.example.panagiotis.m_events.pojo.eventFull_pojo.songkick;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Event_songkick {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("performance")
    @Expose
    private List<Performance_songkick> performance = null;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("series")
    @Expose
    private Series_songkick series;
    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("start")
    @Expose
    private Start_songkick start;
    @SerializedName("end")
    @Expose
    private End_songkick end;
    @SerializedName("ageRestriction")
    @Expose
    private Object ageRestriction;
    @SerializedName("location")
    @Expose
    private Location_songkick location;
    @SerializedName("venue")
    @Expose
    private Venue_songkick venue;
    @SerializedName("popularity")
    @Expose
    private Double popularity;
    @SerializedName("uri")
    @Expose
    private String uri;
    @SerializedName("id")
    @Expose
    private Integer id;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Performance_songkick> getPerformance() {
        return performance;
    }

    public void setPerformance(List<Performance_songkick> performance) {
        this.performance = performance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Series_songkick getSeries() {
        return series;
    }

    public void setSeries(Series_songkick series) {
        this.series = series;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Start_songkick getStart() {
        return start;
    }

    public void setStart(Start_songkick start) {
        this.start = start;
    }

    public End_songkick getEnd() {
        return end;
    }

    public void setEnd(End_songkick end) {
        this.end = end;
    }

    public Object getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(Object ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public Location_songkick getLocation() {
        return location;
    }

    public void setLocation(Location_songkick location) {
        this.location = location;
    }

    public Venue_songkick getVenue() {
        return venue;
    }

    public void setVenue(Venue_songkick venue) {
        this.venue = venue;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
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

}
