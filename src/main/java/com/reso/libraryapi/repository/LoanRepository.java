package com.reso.libraryapi.repository;

import com.reso.libraryapi.model.Loan;
import com.reso.libraryapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LoanRepository extends JpaRepository<Loan,Long> {
}
