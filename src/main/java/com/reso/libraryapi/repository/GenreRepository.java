package com.reso.libraryapi.repository;

import com.reso.libraryapi.model.Book;
import com.reso.libraryapi.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GenreRepository extends JpaRepository<Genre,Long> {
}
