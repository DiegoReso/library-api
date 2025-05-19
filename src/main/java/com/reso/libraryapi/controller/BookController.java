package com.reso.libraryapi.controller;

import com.reso.libraryapi.dto.BookDTO;
import com.reso.libraryapi.model.Book;
import com.reso.libraryapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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

    @GetMapping("/{id}")
    public  ResponseEntity<BookDTO> getById(@PathVariable Long id){
        BookDTO book = service.getById(id);
        return ResponseEntity.ok().body(book);
    }

    @PostMapping
    public ResponseEntity<BookDTO> insertBook(@RequestBody BookDTO book){
        BookDTO bookDTO = service.insert(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@RequestBody BookDTO book, @PathVariable Long id){
        BookDTO bookDTO = service.update(id,book);
        return ResponseEntity.ok(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
