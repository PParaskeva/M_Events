package com.example.panagiotis.m_events.Realm_Models.LastFM_models;

import io.realm.RealmObject;

public class FavorityTags_Realm extends RealmObject {
    private String tagName;
    private boolean value;

    public FavorityTags_Realm() {
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
