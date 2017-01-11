package com.example.panagiotis.m_events.pojo.eventFull_pojo.songkick.SongKick_ArtistCalendar;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Results_ArtistCalendar {

    @SerializedName("event")
    @Expose
    private List<Event_ArtistCalendar> event = null;

    public List<Event_ArtistCalendar> getEvent() {
        return event;
    }

    public void setEvent(List<Event_ArtistCalendar> event) {
        this.event = event;
    }

}

