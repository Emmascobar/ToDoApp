package com.ohmycode.test.controllers;

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

import javax.validation.Valid;


@Controller
public class AdminController {
    @Autowired
    AdminService adminService;
//    @Autowired
//    PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user-form")
    public String newUserForm(Model model) {
        User user = new User();
        model.addAttribute("title", "Add a New User");
        model.addAttribute("user", user);
        return "add_user";
    }
    @PostMapping("/save-user")
    public String createUser(@Valid @ModelAttribute("user") User user) {
//        User user = new User(newUserDTO.getName(),
//                newUserDTO.getUsername(), passwordEncoder.encode(newUserDTO.getPassword()),
//                newUserDTO.getAddress(),
//                Arrays.asList(new Role("ROLE_USER")));
        adminService.addNewUser(user);
        return "redirect:/index";
    }
    public void deleteUser(Long id) {
        adminService.deleteUser(id);
    }
}