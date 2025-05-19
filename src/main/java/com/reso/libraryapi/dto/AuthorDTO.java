package com.reso.libraryapi.dto;


import com.reso.libraryapi.model.Author;
import com.reso.libraryapi.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AuthorDTO {

    private Long id;
    private String name;

    public AuthorDTO() {
    }

    public AuthorDTO(Author writer) {
        this.id = writer.getId();
        this.name = writer.getName();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AuthorDTO authorDTO = (AuthorDTO) o;
        return Objects.equals(id, authorDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
