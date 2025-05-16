package com.reso.libraryapi.service;


import com.reso.libraryapi.model.Book;
import com.reso.libraryapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public List<Book> getAll(){
        List<Book> book = repository.findAll();
        return book;
    }

}
