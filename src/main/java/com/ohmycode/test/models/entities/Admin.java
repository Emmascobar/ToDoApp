package com.ohmycode.test.models.entities;

import com.ohmycode.test.models.utils.Address;
import jakarta.persistence.Entity;

import java.util.Collection;
import java.util.List;

@Entity
public class Admin extends User {
    public Admin() {
    }

    public Admin(String name, String username, String password, Address address, Role role) {
        super(name, username, password, address, role);
    }
}
