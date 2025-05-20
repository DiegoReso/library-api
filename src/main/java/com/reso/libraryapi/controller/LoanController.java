package com.reso.libraryapi.controller;

import com.reso.libraryapi.dto.LoanDTO;
import com.reso.libraryapi.dto.UserDTO;
import com.reso.libraryapi.model.Loan;
import com.reso.libraryapi.service.LoanService;
import com.reso.libraryapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService service;

    @GetMapping
    public ResponseEntity<List<LoanDTO>>  getAll(){
        List<LoanDTO> loans = service.getAll();
        return ResponseEntity.ok(loans);
    }

}
