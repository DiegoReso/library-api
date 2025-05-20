package com.reso.libraryapi.dto;

import com.reso.libraryapi.model.Book;
import com.reso.libraryapi.model.Loan;
import com.reso.libraryapi.model.LoanItem;

import java.util.Objects;
import java.util.Set;

public class LoanItemDTO {

    private Long id;
    private BookDTO book;


    public LoanItemDTO() {
    }


    public LoanItemDTO(LoanItem loanItem) {
        this.id = loanItem.getId();
        this.book = new BookDTO(loanItem.getBook());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BookDTO getBook() {
        return book;
    }

    public void setBook(BookDTO book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LoanItemDTO that = (LoanItemDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
