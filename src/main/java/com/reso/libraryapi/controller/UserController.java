package com.reso.libraryapi.controller;

import com.reso.libraryapi.dto.UserDTO;

import com.reso.libraryapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>>  getAll(){
        List<UserDTO> users = service.getAll();
        return ResponseEntity.ok(users);
    }

}
