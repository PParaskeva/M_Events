package com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.Track_search;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Results_SearchTrack {

    @SerializedName("opensearch:Query")
    @Expose
    private OpensearchQuery_SearchTrack opensearchQuery;
    @SerializedName("opensearch:totalResults")
    @Expose
    private String opensearchTotalResults;
    @SerializedName("opensearch:startIndex")
    @Expose
    private String opensearchStartIndex;
    @SerializedName("opensearch:itemsPerPage")
    @Expose
    private String opensearchItemsPerPage;
    @SerializedName("trackmatches")
    @Expose
    private Trackmatches_SearchTrack trackmatches;
    @SerializedName("@attr")
    @Expose
    private Attr_SearchTrack attr;

    public OpensearchQuery_SearchTrack getOpensearchQuery() {
        return opensearchQuery;
    }

    public void setOpensearchQuery(OpensearchQuery_SearchTrack opensearchQuery) {
        this.opensearchQuery = opensearchQuery;
    }

    public Results_SearchTrack withOpensearchQuery(OpensearchQuery_SearchTrack opensearchQuery) {
        this.opensearchQuery = opensearchQuery;
        return this;
    }

    public String getOpensearchTotalResults() {
        return opensearchTotalResults;
    }

    public void setOpensearchTotalResults(String opensearchTotalResults) {
        this.opensearchTotalResults = opensearchTotalResults;
    }

    public Results_SearchTrack withOpensearchTotalResults(String opensearchTotalResults) {
        this.opensearchTotalResults = opensearchTotalResults;
        return this;
    }

    public String getOpensearchStartIndex() {
        return opensearchStartIndex;
    }

    public void setOpensearchStartIndex(String opensearchStartIndex) {
        this.opensearchStartIndex = opensearchStartIndex;
    }

    public Results_SearchTrack withOpensearchStartIndex(String opensearchStartIndex) {
        this.opensearchStartIndex = opensearchStartIndex;
        return this;
    }

    public String getOpensearchItemsPerPage() {
        return opensearchItemsPerPage;
    }

    public void setOpensearchItemsPerPage(String opensearchItemsPerPage) {
        this.opensearchItemsPerPage = opensearchItemsPerPage;
    }

    public Results_SearchTrack withOpensearchItemsPerPage(String opensearchItemsPerPage) {
        this.opensearchItemsPerPage = opensearchItemsPerPage;
        return this;
    }

    public Trackmatches_SearchTrack getTrackmatches() {
        return trackmatches;
    }

    public void setTrackmatches(Trackmatches_SearchTrack trackmatches) {
        this.trackmatches = trackmatches;
    }

    public Results_SearchTrack withTrackmatches(Trackmatches_SearchTrack trackmatches) {
        this.trackmatches = trackmatches;
        return this;
    }

    public Attr_SearchTrack getAttr() {
        return attr;
    }

    public void setAttr(Attr_SearchTrack attr) {
        this.attr = attr;
    }

    public Results_SearchTrack withAttr(Attr_SearchTrack attr) {
        this.attr = attr;
        return this;
    }

}
