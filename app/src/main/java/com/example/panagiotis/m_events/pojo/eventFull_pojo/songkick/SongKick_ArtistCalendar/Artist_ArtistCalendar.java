package com.example.panagiotis.m_events.pojo.eventFull_pojo.songkick.SongKick_ArtistCalendar;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Artist_ArtistCalendar {

    @SerializedName("identifier")
    @Expose
    private List<Identifier_ArtistCalendar> identifier = null;
    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("uri")
    @Expose
    private String uri;
    @SerializedName("id")
    @Expose
    private Integer id;

    public List<Identifier_ArtistCalendar> getIdentifier() {
        return identifier;
    }

    public void setIdentifier(List<Identifier_ArtistCalendar> identifier) {
        this.identifier = identifier;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
