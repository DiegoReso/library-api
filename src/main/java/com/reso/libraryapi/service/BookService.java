package com.reso.libraryapi.service;

import com.reso.libraryapi.dto.BookDTO;
import com.reso.libraryapi.dto.GenreDTO;
import com.reso.libraryapi.excepetion.service.DatabaseIntegrityException;
import com.reso.libraryapi.excepetion.service.ResourceNotFoundException;
import com.reso.libraryapi.model.Book;
import com.reso.libraryapi.model.Details;
import com.reso.libraryapi.model.Genre;
import com.reso.libraryapi.repository.BookRepository;
import com.reso.libraryapi.repository.GenreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;

import java.util.Set;


@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Transactional(readOnly = true)
    public List<BookDTO> getAll() {
        List<Book> list = bookRepository.findAll();
        return list.stream().map(BookDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public BookDTO getById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + id));
        return new BookDTO(book);
    }

    @Transactional
    public BookDTO insert(BookDTO bookDTO) {
        Book book = new Book();
        updateBookFromDTO(book, bookDTO);
        try {
            book = bookRepository.save(book);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseIntegrityException("Error saving book: " + e.getMessage());
        }
        return new BookDTO(book);
    }

    @Transactional
    public BookDTO update(Long id, BookDTO bookDTO) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
        updateBookFromDTO(book, bookDTO);
        try {
            book = bookRepository.save(book);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseIntegrityException("Error updating book: " + e.getMessage());
        }
        return new BookDTO(book);
    }

    @Transactional
    public void delete(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
        try {
            bookRepository.delete(book);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseIntegrityException("Error deleting book: " + e.getMessage());
        }
    }

    private void updateBookFromDTO(Book book, BookDTO bookDTO) {
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setIsbn(bookDTO.getIsbn());
        book.setPublicationDate(bookDTO.getPublicationDate());
        book.setPublisher(bookDTO.getPublisher());
        if (bookDTO.getDetails() != null) {
            book.setDetails(new Details(bookDTO.getDetails().getNumberOfPages(), bookDTO.getDetails().getSynopsis()));
        }

        Set<Genre> genres = new HashSet<>();
        if (bookDTO.getGenres() != null) {
            for (GenreDTO genreDTO : bookDTO.getGenres()) {
                Genre genre = genreRepository.findById(genreDTO.getId())
                        .orElseThrow(() -> new ResourceNotFoundException("Genre not found with id: " + genreDTO.getId()));
                genres.add(genre);
            }
        }
        book.setGenres(genres);
    }
}

