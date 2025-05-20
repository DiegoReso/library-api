package com.reso.libraryapi.service;

import com.reso.libraryapi.dto.LoanDTO;
import com.reso.libraryapi.dto.UserDTO;
import com.reso.libraryapi.model.Loan;
import com.reso.libraryapi.model.User;
import com.reso.libraryapi.repository.LoanRepository;
import com.reso.libraryapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LoanService {

    @Autowired
    private LoanRepository repository;

    @Transactional(readOnly = true)
    public List<LoanDTO> getAll(){
        List<Loan> loans = repository.findAll();
        return loans.stream().map(LoanDTO::new).toList();


    }

}
