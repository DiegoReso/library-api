package com.reso.libraryapi.dto;

import com.reso.libraryapi.model.Book;

import java.time.LocalDate;
import java.util.Objects;

public class BookDTO {

    private Long id;
    private String title;
    private String author;
    private String isbn;
    private LocalDate publicationDate;
    private String publisher;
    private DetailsDTO details;


    public BookDTO() {
    }

    public BookDTO(DetailsDTO details, Long id, String title, String author, String isbn, LocalDate publicationDate, String publisher) {
        this.details = details;
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.publisher = publisher;
    }

    public BookDTO(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.isbn = book.getIsbn();
        this.publicationDate = book.getPublicationDate();
        this.publisher = book.getPublisher();
        this.details = new DetailsDTO(book.getDetails());
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public DetailsDTO getDetails() {
        return details;
    }

    public void setDetails(DetailsDTO details) {
        this.details = details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDTO bookDTO = (BookDTO) o;
        return Objects.equals(id, bookDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
