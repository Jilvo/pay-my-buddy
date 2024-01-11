//package com.paymybuddy.paymybuddy.controllers;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.paymybuddy.paymybuddy.services.FriendshipService;
//import com.paymybuddy.paymybuddy.services.TransactionService;
//import com.paymybuddy.paymybuddy.services.UserService;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
//
//@WebMvcTest(TransactionController.class)
//public class TransactionControllerTest {
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
//    @WithMockUser
//    public void getTransferTemplateTest() throws Exception {
//        mockMvc.perform(get("/transfer"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("transfer"));
//    }
//
//    @Test
//    @WithMockUser
//    public void createTransactionTest() throws Exception {
//        mockMvc.perform(post("/create_transaction")
//                .param("friendship", "1")
//                .param("amount", "100")
//                .param("description", "Test transaction"))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(view().name("redirect:transfer"));
//    }
//}