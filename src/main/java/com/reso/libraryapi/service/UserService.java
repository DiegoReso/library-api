package com.reso.libraryapi.service;

import com.reso.libraryapi.dto.UserDTO;

import com.reso.libraryapi.model.User;
import com.reso.libraryapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Transactional(readOnly = true)
    public List<UserDTO> getAll(){
        List<User> users = repository.findAll();
        return users.stream().map(UserDTO::new).toList() ;


    }

}
