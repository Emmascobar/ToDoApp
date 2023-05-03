package com.ohmycode.test.models.entities;

import com.ohmycode.test.models.utils.Address;
import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table (name = "users")
public class User implements Serializable {
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
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Role role;

    public User() {
    }

    public User(String name, String username, String password, Address address, Role role) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.address = address;
        this.role = role;
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

    public Role getRoles() {
        return role;
    }

    public void setRoles(Role role) {
        this.role = role;
    }
}
