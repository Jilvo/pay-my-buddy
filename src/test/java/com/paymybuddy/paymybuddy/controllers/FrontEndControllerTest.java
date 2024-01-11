//package com.paymybuddy.paymybuddy.controllers;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.paymybuddy.paymybuddy.services.FriendshipService;
//import com.paymybuddy.paymybuddy.services.TransactionService;
//import com.paymybuddy.paymybuddy.services.UserService;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(FrontEndController.class)
//public class FrontEndControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private TransactionService transactionService;
//
//    @MockBean
//    private FriendshipService friendshipService;
//
//    @MockBean
//    private UserService userService;
//
//    @Test
//    public void getHomeTemplateTest() throws Exception {
//        mockMvc.perform(get("/"))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(redirectedUrl("transfer"));
//    }
//}