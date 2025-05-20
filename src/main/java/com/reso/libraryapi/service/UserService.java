package com.reso.libraryapi.service;

import com.reso.libraryapi.dto.AddressDTO;
import com.reso.libraryapi.dto.UserDTO;

import com.reso.libraryapi.model.Address;
import com.reso.libraryapi.model.User;
import com.reso.libraryapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;


    @Transactional(readOnly = true)
    public List<UserDTO> getAll() {
        List<User> users = repository.findAll();
        List<UserDTO> userDTOs = new ArrayList<>();
        for (User user : users) {
            userDTOs.add(mapToDTO(user));
        }
        return userDTOs;
    }

    @Transactional(readOnly = true)
    public UserDTO getById(Long id) {
        Optional<User> userOptional = repository.findById(id);
        if (userOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id: " + id);
        }
        User user = userOptional.get();
        return mapToDTO(user);
    }

    @Transactional
    public UserDTO insert(UserDTO userDTO) {
        User user = mapToEntity(userDTO);
        User savedUser = repository.save(user);
        return mapToDTO(savedUser);
    }

    @Transactional
    public UserDTO update(Long id, UserDTO userDTO) {
        Optional<User> userOptional = repository.findById(id);
        if (userOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id: " + id);
        }

        User existingUser = userOptional.get();
        existingUser.setName(userDTO.getName());
        existingUser.setAddress(new Address(userDTO.getAddress()));
        User updatedUser = repository.save(existingUser);
        return mapToDTO(updatedUser);
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id: " + id);
        }
        repository.deleteById(id);
    }

    private UserDTO mapToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setAddress(new AddressDTO(user.getAddress()));
        return userDTO;
    }

    private User mapToEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setAddress(new Address(userDTO.getAddress()));
        return user;
    }

}
