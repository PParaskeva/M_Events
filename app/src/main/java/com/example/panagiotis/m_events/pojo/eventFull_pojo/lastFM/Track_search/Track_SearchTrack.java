package com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.Track_search;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Track_SearchTrack {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("artist")
    @Expose
    private String artist;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("streamable")
    @Expose
    private String streamable;
    @SerializedName("listeners")
    @Expose
    private String listeners;
    @SerializedName("image")
    @Expose
    private List<Image_SearchTrack> image = null;
    @SerializedName("mbid")
    @Expose
    private String mbid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Track_SearchTrack withName(String name) {
        this.name = name;
        return this;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Track_SearchTrack withArtist(String artist) {
        this.artist = artist;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Track_SearchTrack withUrl(String url) {
        this.url = url;
        return this;
    }

    public String getStreamable() {
        return streamable;
    }

    public void setStreamable(String streamable) {
        this.streamable = streamable;
    }

    public Track_SearchTrack withStreamable(String streamable) {
        this.streamable = streamable;
        return this;
    }

    public String getListeners() {
        return listeners;
    }

    public void setListeners(String listeners) {
        this.listeners = listeners;
    }

    public Track_SearchTrack withListeners(String listeners) {
        this.listeners = listeners;
        return this;
    }

    public List<Image_SearchTrack> getImage() {
        return image;
    }

    public void setImage(List<Image_SearchTrack> image) {
        this.image = image;
    }

    public Track_SearchTrack withImage(List<Image_SearchTrack> image) {
        this.image = image;
        return this;
    }

    public String getMbid() {
        return mbid;
    }

    public void setMbid(String mbid) {
        this.mbid = mbid;
    }

    public Track_SearchTrack withMbid(String mbid) {
        this.mbid = mbid;
        return this;
    }

}
