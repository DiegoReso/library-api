package com.reso.libraryapi.dto;

import com.reso.libraryapi.model.Loan;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class LoanDTO {

    private Long id;
    private LocalDateTime loanDate;
    private LocalDate expectedReturnDate;
    private LocalDate actualReturnDate;
    private UserDTO user;

    public LoanDTO() {
    }

    public LoanDTO(Loan loan) {
        setId(loan.getId());
        setLoanDate(loan.getLoanDate());
        setUser(new UserDTO(loan.getUser()));
        setActualReturnDate(loan.getActualReturnDate());
        setExpectedReturnDate(loan.getExpectedReturnDate());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDateTime loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getExpectedReturnDate() {
        return expectedReturnDate;
    }

    public void setExpectedReturnDate(LocalDate expectedReturnDate) {
        this.expectedReturnDate = expectedReturnDate;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public LocalDate getActualReturnDate() {
        return actualReturnDate;
    }

    public void setActualReturnDate(LocalDate actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LoanDTO loanDTO = (LoanDTO) o;
        return Objects.equals(id, loanDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
