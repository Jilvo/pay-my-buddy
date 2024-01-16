//package com.paymybuddy.paymybuddy.controllers;
//
//import com.paymybuddy.paymybuddy.controllers.LoginController;
//import com.paymybuddy.paymybuddy.models.BankAccount;
//import com.paymybuddy.paymybuddy.models.User;
//import com.paymybuddy.paymybuddy.services.BankAccountService;
//import com.paymybuddy.paymybuddy.services.UserService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.servlet.view.RedirectView;
//
//import java.math.BigDecimal;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.verify;
//
//public class LoginControllerTest {
//
//    @InjectMocks
//    private LoginController loginController;
//
//    @Mock
//    private UserService userService;
//
//    @Mock
//    private BankAccountService bankAccountService;
//
//    @BeforeEach
//    public void init() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    public void testPerformLogin() {
//        User user = new User();
//        user.setFirstName("John");
//        user.setLastName("Doe");
//        user.setEmail("john.doe@example.com");
//        user.setPassword("password");
//
//        RedirectView redirectView = loginController.performLogin(user);
//
//        verify(userService).connect(user);
//        assertEquals("/transfer", redirectView.getUrl());
//        assertEquals(user, SecurityContextHolder.getContext().getAuthentication().getPrincipal());
//    }
//
//    @Test
//    public void testPerformSignUp() {
//        String firstName = "John";
//        String lastName = "Doe";
//        String email = "john.doe@example.com";
//        String iban = "DE89370400440532013000";
//        String accountNumber = "123456789";
//        BigDecimal balance = BigDecimal.valueOf(1000);
//        String password = "password";
//
//        RedirectView redirectView = loginController.performSignUp(firstName, lastName, email, iban, accountNumber,
//                balance, password);
//
//        verify(userService).createUser(new User(firstName, lastName, password, email, balance, true, "USER"));
//        verify(bankAccountService).createBankAccount(new BankAccount(accountNumber, iban,
//                new User(firstName, lastName, password, email, balance, true, "USER")));
//        assertEquals("transfer", redirectView.getUrl());
//    }
//}