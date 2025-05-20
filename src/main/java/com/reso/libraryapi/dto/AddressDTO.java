package com.reso.libraryapi.dto;

import com.reso.libraryapi.model.Address;

import java.util.Objects;

public class AddressDTO {

    private String street;
    private String number;
    private String city;
    private String state;

    public AddressDTO() {
    }

    public AddressDTO(Address address) {
       setCity(address.getCity());
       setNumber(address.getNumber());
       setState(address.getState());
       setStreet(address.getStreet());
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AddressDTO that = (AddressDTO) o;
        return Objects.equals(street, that.street);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(street);
    }
}
