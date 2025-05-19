package com.reso.libraryapi.repository;

import com.reso.libraryapi.model.Book;
import com.reso.libraryapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
