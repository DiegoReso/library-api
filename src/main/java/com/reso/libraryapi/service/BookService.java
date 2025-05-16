package com.reso.libraryapi.service;


import com.reso.libraryapi.dto.BookDTO;
import com.reso.libraryapi.model.Book;
import com.reso.libraryapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public List<BookDTO> getAll(){
        List<Book> list = repository.findAll();
        return list.stream().map(BookDTO::new).toList();
    }

}
