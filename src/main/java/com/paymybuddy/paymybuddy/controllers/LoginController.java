package com.paymybuddy.paymybuddy.controllers;

import java.math.BigDecimal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.paymybuddy.paymybuddy.models.BankAccount;
import com.paymybuddy.paymybuddy.models.User;
import com.paymybuddy.paymybuddy.services.BankAccountService;
import com.paymybuddy.paymybuddy.services.UserService;

import jakarta.transaction.Transactional;

@Controller
public class LoginController {
    private final UserService userService;
    private final BankAccountService bankAccountService;

    public LoginController(UserService userService, BankAccountService bankAccountService) {
        this.userService = userService;
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String performLogin(@ModelAttribute User user) {
        System.out.println("LoginController.performLogin");
        userService.connect(user);
        return "transfer";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/perform_signup")
    @Transactional
    public RedirectView performSignUp(@RequestParam("first_name") String first_name,
            @RequestParam("last_name") String last_name, @RequestParam("email") String email,
            @RequestParam("iban") String iban, @RequestParam("account_number") String account_number,
            @RequestParam("balance") BigDecimal balance,
            @RequestParam("password") String password) {
        User user = new User(first_name, last_name, password, email, balance, true, "USER");
        User newUser = userService.createUser(user);
        BankAccount account = new BankAccount(account_number, iban, newUser);
        bankAccountService.createBankAccount(account);
        return new RedirectView("transfer");
    }
}
