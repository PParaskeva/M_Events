package com.example.panagiotis.m_events.Realm_Models.LastFM_models;

import io.realm.RealmObject;

/**
 * Created by Panagiotis on 08/01/2017.
 */

public class FavoriteArtists_Realm extends RealmObject {

    private int ArtistPopularity;
    private String ArtistName;
    private String ArtistID;
    private String ArtistImage;


    public FavoriteArtists_Realm() {
    }

    public int getArtistPopularity() {
        return ArtistPopularity;
    }

    public void setArtistPopularity(int artistPopularity) {
        ArtistPopularity = artistPopularity;
    }

    public String getArtistImage() {
        return ArtistImage;
    }

    public void setArtistImage(String artistImage) {
        ArtistImage = artistImage;
    }

    public String getArtistName() {
        return ArtistName;
    }

    public void setArtistName(String artistName) {
        ArtistName = artistName;
    }

    public String getArtistID() {
        return ArtistID;
    }

    public void setArtistID(String artistID) {
        ArtistID = artistID;
    }

}
