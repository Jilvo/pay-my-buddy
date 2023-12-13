package com.paymybuddy.paymybuddy.controllers;

import com.paymybuddy.paymybuddy.models.User;
import com.paymybuddy.paymybuddy.services.BankAccountService;
import com.paymybuddy.paymybuddy.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {
    private final UserService userService;
    private final BankAccountService bankAccountService;

    public SignUpController(UserService userService, BankAccountService bankAccountService) {
        this.userService = userService;
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/perform_signup")
    public String performSignUp(@ModelAttribute User user) {

        userService.createUser(user);
        bankAccountService.createBankAccount(user);
        return "signup";
    }
}