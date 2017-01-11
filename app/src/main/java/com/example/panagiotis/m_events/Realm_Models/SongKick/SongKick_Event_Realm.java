package com.example.panagiotis.m_events.Realm_Models.SongKick;

import io.realm.RealmObject;

/**
 * Created by Panagiotis on 06/01/2017.
 */

public class SongKick_Event_Realm extends RealmObject {
    private String EventName;
    private double Longitude;
    private double Latitude;
    private String venueName;

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String eventName) {
        EventName = eventName;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public SongKick_Event_Realm() {
    }
}
