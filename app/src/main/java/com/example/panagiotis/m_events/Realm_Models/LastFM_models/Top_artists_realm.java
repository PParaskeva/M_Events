package com.example.panagiotis.m_events.Realm_Models.LastFM_models;

import io.realm.RealmObject;

/**
 * Created by Panagiotis on 02/01/2017.
 */

public class Top_artists_realm extends RealmObject {

    private String name;

    private String listeners;

    private String mbid;

    private String url;

    private String streamable;

    private String image_url1;
    private String image_url2;
    private String image_url3;

    public String getImage_url1() {
        return image_url1;
    }

    public void setImage_url1(String image_url1) {
        this.image_url1 = image_url1;
    }

    public String getImage_url2() {
        return image_url2;
    }

    public void setImage_url2(String image_url2) {
        this.image_url2 = image_url2;
    }

    public String getImage_url3() {
        return image_url3;
    }

    public void setImage_url3(String image_url3) {
        this.image_url3 = image_url3;
    }

    public String getImage_url4() {
        return image_url4;
    }

    public void setImage_url4(String image_url4) {
        this.image_url4 = image_url4;
    }

    public String getImage_url5() {
        return image_url5;
    }

    public void setImage_url5(String image_url5) {
        this.image_url5 = image_url5;
    }

    private String image_url4;
    private String image_url5;

    public Top_artists_realm() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getListeners() {
        return listeners;
    }

    public void setListeners(String listeners) {
        this.listeners = listeners;
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

    public String getStreamable() {
        return streamable;
    }

    public void setStreamable(String streamable) {
        this.streamable = streamable;
    }
}
