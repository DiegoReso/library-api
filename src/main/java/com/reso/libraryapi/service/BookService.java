package com.reso.libraryapi.service;


import com.reso.libraryapi.dto.BookDTO;
import com.reso.libraryapi.dto.GenreDTO;
import com.reso.libraryapi.excepetion.service.ResourceNotFoundException;
import com.reso.libraryapi.model.Book;
import com.reso.libraryapi.model.Details;
import com.reso.libraryapi.model.Genre;
import com.reso.libraryapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
        return repository.findById(id).map(BookDTO::new).orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + id));
    }

    @Transactional
    public BookDTO insert(BookDTO bookDTO) {
        Book book = new Book();
        updateBookFromDTO(book, bookDTO);
        book = repository.save(book);
        return new BookDTO(book);
    }

    private void updateBookFromDTO(Book entity, BookDTO bookDTO) {
        entity.setTitle(bookDTO.getTitle());
        entity.setAuthor(bookDTO.getAuthor());
        entity.setIsbn(bookDTO.getIsbn());
        entity.setPublicationDate(bookDTO.getPublicationDate());
        entity.setPublisher(bookDTO.getPublisher());
        if (bookDTO.getDetails() != null) {
            entity.setDetails(new Details(bookDTO.getDetails().getNumberOfPages(), bookDTO.getDetails().getSynopsis()));
        }


        Set<Genre> genres = new HashSet<>();
        if (bookDTO.getGenres() != null) {
            for (GenreDTO genreDTO : bookDTO.getGenres()) {
                Genre genre = new Genre();
                genre.setId(genreDTO.getId());
                genre.setName(genreDTO.getName());
                genres.add(genre);
            }
        }
        entity.setGenres(genres);
    }
}
