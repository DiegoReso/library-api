package com.reso.libraryapi.controller;

import com.reso.libraryapi.dto.UserDTO;

import com.reso.libraryapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
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

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable Long id) {
        UserDTO user = service.getById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<UserDTO> insert(@RequestBody UserDTO userDTO) {
        UserDTO newUser = service.insert(userDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newUser.getId())
                .toUri();
        return ResponseEntity.created(uri).body(newUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        UserDTO updatedUser = service.update(id, userDTO);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
