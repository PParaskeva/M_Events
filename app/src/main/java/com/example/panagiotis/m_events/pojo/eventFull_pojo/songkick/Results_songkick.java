package com.example.panagiotis.m_events.pojo.eventFull_pojo.songkick;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Results_songkick {

    @SerializedName("event")
    @Expose
    private List<Event_songkick> event = null;

    public List<Event_songkick> getEvent() {
        return event;
    }

    public void setEvent(List<Event_songkick> event) {
        this.event = event;
    }

}

