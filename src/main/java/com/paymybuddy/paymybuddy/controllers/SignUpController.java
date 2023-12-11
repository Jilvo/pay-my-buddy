package com.paymybuddy.paymybuddy.controllers;
import com.paymybuddy.paymybuddy.models.User;
import com.paymybuddy.paymybuddy.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class SignUpController {
    private final UserService userService;

    public SignUpController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/signup")
    public String login() {
        return "signup";
    }

    @PostMapping("/perform_signup")
    public String performLogin(@ModelAttribute User user) {
        userService.createUser(user);
        return "login";
    }
}