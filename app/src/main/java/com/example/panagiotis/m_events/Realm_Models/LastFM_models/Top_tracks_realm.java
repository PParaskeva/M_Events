package com.example.panagiotis.m_events.Realm_Models.LastFM_models;

import io.realm.RealmObject;

/**
 * Created by Panagiotis on 03/01/2017.
 */

public class Top_tracks_realm extends RealmObject {

    public Top_tracks_realm() {
    }

    private String Artist;
    private String Duration;
    private String Mbid;
    private String name;
    private String rank;
    private String image_url;

    public String getArtist() {
        return Artist;
    }

    public void setArtist(String artist) {
        Artist = artist;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public String getMbid() {
        return Mbid;
    }

    public void setMbid(String mbid) {
        Mbid = mbid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
