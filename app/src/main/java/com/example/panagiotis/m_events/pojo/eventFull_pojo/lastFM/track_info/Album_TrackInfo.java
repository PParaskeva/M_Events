package com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.track_info;


 import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Album_TrackInfo {

    @SerializedName("artist")
    @Expose
    private String artist;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("mbid")
    @Expose
    private String mbid;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("image")
    @Expose
    private List<Image_TrackInfo> image = null;
    @SerializedName("@attr")
    @Expose
    private Attr_TrackInfo attr;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public List<Image_TrackInfo> getImage() {
        return image;
    }

    public void setImage(List<Image_TrackInfo> image) {
        this.image = image;
    }

    public Attr_TrackInfo getAttr() {
        return attr;
    }

    public void setAttr(Attr_TrackInfo attr) {
        this.attr = attr;
    }

}
