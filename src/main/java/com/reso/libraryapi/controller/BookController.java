package com.reso.libraryapi.controller;

import com.reso.libraryapi.dto.BookDTO;
import com.reso.libraryapi.model.Book;
import com.reso.libraryapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAll(){
        List<BookDTO> list = service.getAll();
        return ResponseEntity.ok().body(list);
    }

}
