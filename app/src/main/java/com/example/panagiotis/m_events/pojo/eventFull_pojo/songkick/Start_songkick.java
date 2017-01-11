package com.example.panagiotis.m_events.pojo.eventFull_pojo.songkick;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Start_songkick {

    @SerializedName("time")
    @Expose
    private Object time;
    @SerializedName("datetime")
    @Expose
    private Object datetime;
    @SerializedName("date")
    @Expose
    private String date;

    public Object getTime() {
        return time;
    }

    public void setTime(Object time) {
        this.time = time;
    }

    public Object getDatetime() {
        return datetime;
    }

    public void setDatetime(Object datetime) {
        this.datetime = datetime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
