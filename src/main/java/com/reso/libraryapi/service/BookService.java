package com.reso.libraryapi.service;


import com.reso.libraryapi.dto.BookDTO;
import com.reso.libraryapi.excepetion.service.ResourceNotFoundException;
import com.reso.libraryapi.model.Book;
import com.reso.libraryapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    @Transactional(readOnly = true)
    public List<BookDTO> getAll(){
        List<Book> list = repository.findAll();
        return list.stream().map(BookDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public BookDTO getById(Long id){
        return repository.findById(id).map(BookDTO::new).orElseThrow(() -> new ResourceNotFoundException("Book not found " +
                "with id " + id));

    }

}
