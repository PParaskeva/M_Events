package com.example.panagiotis.m_events.Realm_Models.LastFM_models;

import io.realm.RealmObject;

/**
 * Created by Panagiotis on 08/01/2017.
 */

public class Temp_Realm extends RealmObject{
    private boolean check;
    private String TempName;
    private String TempArtisName;
    private String TempID;
    private String TempImage;

    public Temp_Realm() {
    }

    public boolean isCheck() {
        return check;
    }

    public String getTempArtisName() {
        return TempArtisName;
    }

    public void setTempArtisName(String tempArtisName) {
        TempArtisName = tempArtisName;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public String getTempName() {
        return TempName;
    }

    public void setTempName(String tempName) {
        TempName = tempName;
    }

    public String getTempID() {
        return TempID;
    }

    public void setTempID(String tempID) {
        TempID = tempID;
    }

    public String getTempImage() {
        return TempImage;
    }

    public void setTempImage(String tempImage) {
        TempImage = tempImage;
    }
}
