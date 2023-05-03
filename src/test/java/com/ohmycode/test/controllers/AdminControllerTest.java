package com.ohmycode.test.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ohmycode.test.models.entities.Role;
import com.ohmycode.test.models.entities.ToDo;
import com.ohmycode.test.models.entities.User;
import com.ohmycode.test.models.utils.Address;
import com.ohmycode.test.repository.ToDoRepository;
import com.ohmycode.test.repository.UserRepository;
import com.ohmycode.test.services.interfaces.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@WebMvcTest(UserController.class)
class AdminControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
    private UserController userController;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ToDoRepository toDoRepository;

    @Autowired
    UserService userService;
    private User user;
    private ToDo todo;
    private Address address;

//    @BeforeEach
//    void setUp() {
//        user = new User("Bart Simpson", "Bart2023", "Barto10",null, null);
//        userRepository.save(user);
//        todo = new ToDo("Rent a car for vacations", user);
//        toDoRepository.save(todo);
//
//        userController = new UserController();
//    }
//
//    @AfterEach
//    void tearDown() {
//        userRepository.deleteAll();
//        toDoRepository.deleteAll();
//    }
//    @Test
//    public void testIndex() throws Exception {
//
//        when(userService.getToDoList("Rent").contains(todo));
//
//        mockMvc.perform(get("/index"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("index"))
//                        .andExpect(MockMvcResultMatchers.model().attributeDoesNotExist("Hola"))
//                                .andExpect()
//
//
//        assertEquals("Welcome to this simple 'TO DO APP'", view());
//    }
//    @Test
//    void newUserForm() {
//    }
//
//    @Test
//    void createUser() {
//    }
//
//    @Test
//    void deleteUser() {
//    }
}