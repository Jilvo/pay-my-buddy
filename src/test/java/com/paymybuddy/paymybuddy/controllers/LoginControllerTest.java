package com.paymybuddy.paymybuddy.controllers;

import com.paymybuddy.paymybuddy.models.BankAccount;
import com.paymybuddy.paymybuddy.models.User;
import com.paymybuddy.paymybuddy.services.BankAccountService;
import com.paymybuddy.paymybuddy.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class LoginControllerTest {

    @Mock
    private UserService userService;

    @Mock
    private BankAccountService bankAccountService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        LoginController loginController = new LoginController(userService, bankAccountService);
        mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
    }


    @Test
    public void testPerformLogin() throws Exception {
        User user = new User();
        // when(userService.connect(any(User.class))).thenReturn(user);

        mockMvc.perform(post("/perform_login")
                        .param("username", "test@test.com")
                        .param("password", "password"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/transfer"));
    }


    @Test
    public void testPerformSignUp() throws Exception {
        when(userService.isUserExist(any(String.class))).thenReturn(false);
        when(userService.createUser(any(User.class))).thenReturn(new User());
        when(bankAccountService.createBankAccount(any(BankAccount.class))).thenReturn(new BankAccount());

        mockMvc.perform(post("/perform_signup")
                        .param("first_name", "Test")
                        .param("last_name", "User")
                        .param("email", "test@test.com")
                        .param("iban", "DE89370400440532013000")
                        .param("account_number", "12345678")
                        .param("balance", "1000")
                        .param("password", "password"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("transfer"));
    }
}