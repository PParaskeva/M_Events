package com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Tags_ArtistGetInfo {

    @SerializedName("tag")
    @Expose
    private List<Tag_ArtistGetInfo> tag = null;

    public List<Tag_ArtistGetInfo> getTag() {
        return tag;
    }

    public void setTag(List<Tag_ArtistGetInfo> tag) {
        this.tag = tag;
    }

}
