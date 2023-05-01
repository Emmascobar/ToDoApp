package com.ohmycode.test.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ohmycode.test.models.entities.ToDo;
import com.ohmycode.test.models.entities.User;
import com.ohmycode.test.models.utils.Address;
import com.ohmycode.test.repository.ToDoRepository;
import com.ohmycode.test.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
//
//    @Autowired
//    UserRepository userRepository;
//    @Autowired
//    ToDoRepository toDoRepository;
//
//    @BeforeEach
//    void setUp() {
//        User user = new User("Bart Simpson", "Bart2023", "Barto10", null, null);
//        User user02 = new User("Lisa Simpson", "Lisa2023", "Lisa11", null, null);
//        userRepository.save(user);
//        userRepository.save(user02);
//        ToDo todo = new ToDo("Rent a car for vacations", user);
//        ToDo todo02 = new ToDo("Buy Fruits for breakfast", user02);
//        toDoRepository.save(todo);
//        toDoRepository.save(todo02);
//    }
//
//    @Test
//    void index() {
//    }
//
//    @Test
//    void findToDos() throws Exception {
//    }
//
//    @Test
//    void getAllPages() {
//    }
//
//    @Test
//    void addNewToDo() {
//    }
//
//    @Test
//    void deleteTask() {
//    }
}