package com.reso.libraryapi.dto;

import com.reso.libraryapi.model.Address;
import com.reso.libraryapi.model.User;

import java.util.Objects;

public class UserDTO {

    private Long id;
    private String name;
    private AddressDTO address;

    public UserDTO() {
    }

    public UserDTO(User user){
        setId(user.getId());
        setName(user.getName());
        setAddress(new AddressDTO(user.getAddress()));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(id, userDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
