package com.musiclibraryapp.dto;

import lombok.Data;

@Data
public class SearchDTO {

    private String searchTitle;
    private String searchBy;
    

    public String getSearchTitle() {
        return searchTitle;
    }

    public void setSearchTitle(String searchTitle) {
        this.searchTitle = searchTitle;
    }

    public String getSearchBy() {
        return searchBy;
    }

    public void setSearchBy(String searchBy) {
        this.searchBy = searchBy;
    }
}
