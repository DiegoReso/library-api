package com.reso.libraryapi.dto;

import com.reso.libraryapi.model.Book;
import com.reso.libraryapi.model.Details;

import java.util.Set;

public class DetailsDTO {

    private Integer numberOfPages;
    private String synopsis;

    public DetailsDTO(Details details) {
        this.numberOfPages = details.getNumberOfPages();
        this.synopsis = details.getSynopsis();
    }

    public DetailsDTO(Integer numberOfPages, String synopsis) {
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
