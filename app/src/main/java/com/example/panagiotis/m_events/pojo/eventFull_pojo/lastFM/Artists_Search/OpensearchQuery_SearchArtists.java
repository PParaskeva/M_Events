package com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.Artists_Search;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OpensearchQuery_SearchArtists {

    @SerializedName("#text")
    @Expose
    private String text;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("searchTerms")
    @Expose
    private String searchTerms;
    @SerializedName("startPage")
    @Expose
    private String startPage;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSearchTerms() {
        return searchTerms;
    }

    public void setSearchTerms(String searchTerms) {
        this.searchTerms = searchTerms;
    }

    public String getStartPage() {
        return startPage;
    }

    public void setStartPage(String startPage) {
        this.startPage = startPage;
    }

}
