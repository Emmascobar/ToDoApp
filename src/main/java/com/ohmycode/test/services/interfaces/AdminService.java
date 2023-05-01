package com.ohmycode.test.services.interfaces;

import com.ohmycode.test.models.entities.User;

public interface AdminService {

    User addNewUser(User user);
    void deleteUser(Long id);

}
