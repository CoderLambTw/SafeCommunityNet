package com.youngwu.safecommunitynet.controller;

import com.youngwu.safecommunitynet.model.entity.User;
import com.youngwu.safecommunitynet.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void testCreateUser() throws Exception {
        User user = new User();
        user.setUsername("testUser");
        user.setEmail("test@example.com");
        user.setPassword("123456");

        doNothing().when(userService).createUser(any(User.class));

        mockMvc.perform(post("/api/users")
                        .contentType("application/json")
                        .content("{\"name\": \"testUser\", \"email\": \"test@example.com\", \"password\": \"123456\"}"))
                .andExpect(status().isOk());

        verify(userService, times(1)).createUser(any(User.class));
    }

    @Test
    void testGetUsers() throws Exception {
        mockMvc.perform(get("/api/users/all")
                        .contentType("application/json"))
                .andExpect(status().isOk());

        verify(userService, times(1)).getAllUsers();
    }
}