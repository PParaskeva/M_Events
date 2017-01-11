package com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.track_info;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Toptags_TrackInfo {

    @SerializedName("tag")
    @Expose
    private List<Tag_TrackInfo> tag = null;

    public List<Tag_TrackInfo> getTag() {
        return tag;
    }

    public void setTag(List<Tag_TrackInfo> tag) {
        this.tag = tag;
    }

}
