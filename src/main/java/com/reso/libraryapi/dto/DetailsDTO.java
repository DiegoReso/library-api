package com.reso.libraryapi.dto;

import com.reso.libraryapi.model.Details;

public class DetailsDTO {

    private Integer numberOfPages;
    private String synopsis;

    public DetailsDTO() {
    }

    public DetailsDTO(Details details) {
        this.numberOfPages = details.getNumberOfPages();
        this.synopsis = details.getSynopsis();
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
