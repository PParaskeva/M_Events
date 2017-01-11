package com.example.panagiotis.m_events.Realm_Models.LastFM_models;

import io.realm.RealmObject;

/**
 * Created by Panagiotis on 08/01/2017.
 */

public class FavotiteTracks_Realm extends RealmObject {
    private int TrackPopularity;
    private String TrackName;
    private String TrackID;
    private String TrackImage;

    public FavotiteTracks_Realm() {
    }

    public int getTrackPopularity() {
        return TrackPopularity;
    }

    public void setTrackPopularity(int trackPopularity) {
        TrackPopularity = trackPopularity;
    }

    public String getTrackName() {
        return TrackName;
    }

    public void setTrackName(String trackName) {
        TrackName = trackName;
    }

    public String getTrackID() {
        return TrackID;
    }

    public void setTrackID(String trackID) {
        TrackID = trackID;
    }

    public String getTrackImage() {
        return TrackImage;
    }

    public void setTrackImage(String trackImage) {
        TrackImage = trackImage;
    }
}
