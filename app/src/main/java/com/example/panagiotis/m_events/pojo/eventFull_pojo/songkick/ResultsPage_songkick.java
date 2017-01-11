package com.example.panagiotis.m_events.pojo.eventFull_pojo.songkick;

 import com.google.gson.annotations.Expose;
 import com.google.gson.annotations.SerializedName;

public class ResultsPage_songkick {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("results")
    @Expose
    private Results_songkick results;
    @SerializedName("perPage")
    @Expose
    private Integer perPage;
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("totalEntries")
    @Expose
    private Integer totalEntries;
    @SerializedName("clientLocation")
    @Expose
    private ClientLocation_songkick clientLocation;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Results_songkick getResults() {
        return results;
    }

    public void setResults(Results_songkick results) {
        this.results = results;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalEntries() {
        return totalEntries;
    }

    public void setTotalEntries(Integer totalEntries) {
        this.totalEntries = totalEntries;
    }

    public ClientLocation_songkick getClientLocation() {
        return clientLocation;
    }

    public void setClientLocation(ClientLocation_songkick clientLocation) {
        this.clientLocation = clientLocation;
    }

}
