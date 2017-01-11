package com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.Artists_Search;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attr_SearchArtists {

    @SerializedName("for")
    @Expose
    private String _for;

    public String getFor() {
        return _for;
    }

    public void setFor(String _for) {
        this._for = _for;
    }

}
