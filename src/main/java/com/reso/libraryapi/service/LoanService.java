package com.reso.libraryapi.service;

import com.reso.libraryapi.dto.LoanDTO;

import com.reso.libraryapi.excepetion.service.ResourceNotFoundException;
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

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<LoanDTO> getAll(){
        List<Loan> loans = repository.findAll();
        return loans.stream().map(LoanDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public LoanDTO getById(Long id) {
        Loan loan = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found with id " + id));
        return new LoanDTO(loan);
    }

    @Transactional
    public LoanDTO insert(LoanDTO loanDTO) {
        Loan loan = new Loan();
        updateLoanFromDTO(loan, loanDTO);
        loan = repository.save(loan);
        return new LoanDTO(loan);
    }

    @Transactional
    public LoanDTO update(Long id, LoanDTO loanDTO) {
        Loan existingLoan = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found with id: " + id));
        updateLoanFromDTO(existingLoan, loanDTO);
        Loan updatedLoan = repository.save(existingLoan);
        return new LoanDTO(updatedLoan);
    }

    @Transactional
    public void delete(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found with id: " + id));
        repository.deleteById(id);
    }

    private void updateLoanFromDTO(Loan loan, LoanDTO loanDTO) {
        loan.setLoanDate(loanDTO.getLoanDate());
        loan.setExpectedReturnDate(loanDTO.getExpectedReturnDate());
        loan.setActualReturnDate(loanDTO.getActualReturnDate());


        if (loanDTO.getUser() != null && loanDTO.getUser().getId() != null) {
            User user = userRepository.findById(loanDTO.getUser().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + loanDTO.getUser().getId()));
            loan.setUser(user);
        }
    }

}
