package com.example.panagiotis.m_events.pojo.eventFull_pojo.songkick;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Artist_songkick {

    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("uri")
    @Expose
    private String uri;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("identifier")
    @Expose
    private List<Identifier_songkick> identifier = null;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Identifier_songkick> getIdentifier() {
        return identifier;
    }

    public void setIdentifier(List<Identifier_songkick> identifier) {
        this.identifier = identifier;
    }

}

