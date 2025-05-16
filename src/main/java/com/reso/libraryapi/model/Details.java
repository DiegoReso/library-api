package com.reso.libraryapi.model;

import jakarta.persistence.*;

@Embeddable
public class Details {

    private Integer numberOfPages;
    private String synopsis;

    public Details() {
    }

    public Details(Integer numberOfPages, String synopsis) {
        this.numberOfPages = numberOfPages;
        this.synopsis = synopsis;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }


}
