package com.example.panagiotis.m_events.Realm_Models;

import io.realm.RealmObject;

/**
 * Created by Panagiotis on 06/01/2017.
 */

public class location_Realm extends RealmObject {
    private double lat;
    private double lot;
    private String Country;

    public location_Realm() {
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLot() {
        return lot;
    }

    public void setLot(double lot) {
        this.lot = lot;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }
}
