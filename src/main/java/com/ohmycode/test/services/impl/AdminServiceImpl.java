package com.ohmycode.test.services.impl;

import com.ohmycode.test.models.entities.User;
import com.ohmycode.test.repository.UserRepository;
import com.ohmycode.test.services.interfaces.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    UserRepository userRepository;

    public User addNewUser(User user) {
        return userRepository.save(user);
    }
    public void deleteUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            userRepository.deleteById(id);
        }
    }
}
