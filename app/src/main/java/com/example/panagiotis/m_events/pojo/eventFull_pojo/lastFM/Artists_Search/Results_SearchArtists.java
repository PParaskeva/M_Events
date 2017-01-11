package com.example.panagiotis.m_events.pojo.eventFull_pojo.lastFM.Artists_Search;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Results_SearchArtists {

    @SerializedName("opensearch:Query")
    @Expose
    private OpensearchQuery_SearchArtists opensearchQuery;
    @SerializedName("opensearch:totalResults")
    @Expose
    private String opensearchTotalResults;
    @SerializedName("opensearch:startIndex")
    @Expose
    private String opensearchStartIndex;
    @SerializedName("opensearch:itemsPerPage")
    @Expose
    private String opensearchItemsPerPage;
    @SerializedName("artistmatches")
    @Expose
    private Artistmatches_SearchArtists artistmatches;
    @SerializedName("@attr")
    @Expose
    private Attr_SearchArtists attr;

    public OpensearchQuery_SearchArtists getOpensearchQuery() {
        return opensearchQuery;
    }

    public void setOpensearchQuery(OpensearchQuery_SearchArtists opensearchQuery) {
        this.opensearchQuery = opensearchQuery;
    }

    public String getOpensearchTotalResults() {
        return opensearchTotalResults;
    }

    public void setOpensearchTotalResults(String opensearchTotalResults) {
        this.opensearchTotalResults = opensearchTotalResults;
    }

    public String getOpensearchStartIndex() {
        return opensearchStartIndex;
    }

    public void setOpensearchStartIndex(String opensearchStartIndex) {
        this.opensearchStartIndex = opensearchStartIndex;
    }

    public String getOpensearchItemsPerPage() {
        return opensearchItemsPerPage;
    }

    public void setOpensearchItemsPerPage(String opensearchItemsPerPage) {
        this.opensearchItemsPerPage = opensearchItemsPerPage;
    }

    public Artistmatches_SearchArtists getArtistmatches() {
        return artistmatches;
    }

    public void setArtistmatches(Artistmatches_SearchArtists artistmatches) {
        this.artistmatches = artistmatches;
    }

    public Attr_SearchArtists getAttr() {
        return attr;
    }

    public void setAttr(Attr_SearchArtists attr) {
        this.attr = attr;
    }

}
