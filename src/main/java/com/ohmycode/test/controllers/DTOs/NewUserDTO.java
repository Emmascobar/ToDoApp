package com.ohmycode.test.controllers.DTOs;

import com.ohmycode.test.models.utils.Address;
import jakarta.persistence.Embedded;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.NotEmpty;

public class NewUserDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @NotNull
    private Long id;
    @NotEmpty(message = "Insert a Full Name")
    private String name;
    @NotEmpty(message = "Insert a username")
    private String username;
    @NotEmpty(message = "Insert a password")
    private String password;
    @Embedded
    private Address address;

    public NewUserDTO() {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
