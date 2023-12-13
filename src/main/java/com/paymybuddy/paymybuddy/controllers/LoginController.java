package com.paymybuddy.paymybuddy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.paymybuddy.paymybuddy.models.User;
import com.paymybuddy.paymybuddy.services.BankAccountService;
import com.paymybuddy.paymybuddy.services.UserService;

@Controller
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/perform_login")
    public String performLogin(@ModelAttribute User user) {
        System.out.println("LoginController.performLogin");
        userService.connect(user);
        return "transfer";
    }
}
