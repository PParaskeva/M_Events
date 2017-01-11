package com.example.panagiotis.m_events.Realm_Models;

import io.realm.RealmObject;

/**
 * Created by Panagiotis on 22/12/2016.
 */

public class Facebook_User_Details extends RealmObject{

    String name;
    String lastName;
    String ProfilePictureUrl;

    public Facebook_User_Details() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProfilePictureUrl() {
        return ProfilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        ProfilePictureUrl = profilePictureUrl;
    }
}
