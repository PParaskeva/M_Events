package com.example.panagiotis.m_events.Realm_Models.SongKick;

import io.realm.RealmObject;



public class SongKick_Artist_Realm extends RealmObject {

    private String EventName;
    private String venueName;
    private String ArtistName;

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String eventName) {
        EventName = eventName;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getArtistName() {
        return ArtistName;
    }

    public void setArtistName(String artistName) {
        ArtistName = artistName;
    }

    public SongKick_Artist_Realm() {
    }
}
