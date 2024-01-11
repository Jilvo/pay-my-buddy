//package com.paymybuddy.paymybuddy.controllers;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.paymybuddy.paymybuddy.models.User;
//import com.paymybuddy.paymybuddy.services.FriendshipService;
//import com.paymybuddy.paymybuddy.services.UserService;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(FriendshipController.class)
//public class FriendshipControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private FriendshipService friendshipService;
//
//    @MockBean
//    private UserService userService;
//
//    @Test
//    @WithMockUser(username = "test@test.com")
//    public void createConnectionTest() throws Exception {
//        User user = new User();
//        user.setEmail("test@test.com");
//
//        when(userService.getUserById(any(Integer.class))).thenReturn(user);
//        when(userService.findUserByEmail(any(String.class))).thenReturn(user);
//
//        mockMvc.perform(post("/create_connection").param("new_friend_id", "1"))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(redirectedUrl("transfer"));
//    }
//}