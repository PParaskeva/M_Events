package com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Artist_ArtistGetInfo {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("mbid")
    @Expose
    private String mbid;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("image")
    @Expose
    private List<Image_ArtistGetInfo> image = null;
    @SerializedName("streamable")
    @Expose
    private String streamable;
    @SerializedName("ontour")
    @Expose
    private String ontour;
    @SerializedName("stats")
    @Expose
    private Stats_ArtistGetInfo stats;
    @SerializedName("similar")
    @Expose
    private Similar_ArtistGetInfo similar;
    @SerializedName("tags")
    @Expose
    private Tags_ArtistGetInfo tags;
    @SerializedName("bio")
    @Expose
    private Bio_ArtistGetInfo bio;

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

    public List<Image_ArtistGetInfo> getImage() {
        return image;
    }

    public void setImage(List<Image_ArtistGetInfo> image) {
        this.image = image;
    }

    public String getStreamable() {
        return streamable;
    }

    public void setStreamable(String streamable) {
        this.streamable = streamable;
    }

    public String getOntour() {
        return ontour;
    }

    public void setOntour(String ontour) {
        this.ontour = ontour;
    }

    public Stats_ArtistGetInfo getStats() {
        return stats;
    }

    public void setStats(Stats_ArtistGetInfo stats) {
        this.stats = stats;
    }

    public Similar_ArtistGetInfo getSimilar() {
        return similar;
    }

    public void setSimilar(Similar_ArtistGetInfo similar) {
        this.similar = similar;
    }

    public Tags_ArtistGetInfo getTags() {
        return tags;
    }

    public void setTags(Tags_ArtistGetInfo tags) {
        this.tags = tags;
    }

    public Bio_ArtistGetInfo getBio() {
        return bio;
    }

    public void setBio(Bio_ArtistGetInfo bio) {
        this.bio = bio;
    }

}

