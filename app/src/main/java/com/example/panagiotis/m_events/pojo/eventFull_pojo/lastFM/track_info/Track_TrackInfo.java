package com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.track_info;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Track_TrackInfo {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("mbid")
    @Expose
    private String mbid;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("duration")
    @Expose
    private String duration;
    @SerializedName("streamable")
    @Expose
    private Streamable_TrackInfo streamable;
    @SerializedName("listeners")
    @Expose
    private String listeners;
    @SerializedName("playcount")
    @Expose
    private String playcount;
    @SerializedName("artist")
    @Expose
    private Artist_TrackInfo artist;
    @SerializedName("album")
    @Expose
    private Album_TrackInfo album;
    @SerializedName("toptags")
    @Expose
    private Toptags_TrackInfo toptags;
    @SerializedName("wiki")
    @Expose
    private Wiki_TrackInfo wiki;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMbid() {
        return mbid;
    }

    public void setMbid(String mbid) {
        this.mbid = mbid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Streamable_TrackInfo getStreamable() {
        return streamable;
    }

    public void setStreamable(Streamable_TrackInfo streamable) {
        this.streamable = streamable;
    }

    public String getListeners() {
        return listeners;
    }

    public void setListeners(String listeners) {
        this.listeners = listeners;
    }

    public String getPlaycount() {
        return playcount;
    }

    public void setPlaycount(String playcount) {
        this.playcount = playcount;
    }

    public Artist_TrackInfo getArtist() {
        return artist;
    }

    public void setArtist(Artist_TrackInfo artist) {
        this.artist = artist;
    }

    public Album_TrackInfo getAlbum() {
        return album;
    }

    public void setAlbum(Album_TrackInfo album) {
        this.album = album;
    }

    public Toptags_TrackInfo getToptags() {
        return toptags;
    }

    public void setToptags(Toptags_TrackInfo toptags) {
        this.toptags = toptags;
    }

    public Wiki_TrackInfo getWiki() {
        return wiki;
    }

    public void setWiki(Wiki_TrackInfo wiki) {
        this.wiki = wiki;
    }

}
