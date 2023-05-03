package com.ohmycode.test.controllers;

import com.ohmycode.test.controllers.DTOs.NewUserDTO;
import com.ohmycode.test.models.entities.Role;
import com.ohmycode.test.models.entities.User;
import com.ohmycode.test.repository.UserRepository;
import com.ohmycode.test.services.interfaces.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Collection;


@Controller
public class AdminController {
    @Autowired
    AdminService adminService;
//    @Autowired
//    PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    public void deleteUser(Long id) {
        adminService.deleteUser(id);
    }
}