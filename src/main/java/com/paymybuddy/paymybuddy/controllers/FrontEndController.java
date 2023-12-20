package com.paymybuddy.paymybuddy.controllers;

import com.paymybuddy.paymybuddy.models.Friendship;
import com.paymybuddy.paymybuddy.models.Transaction;
import com.paymybuddy.paymybuddy.models.User;
import com.paymybuddy.paymybuddy.services.FriendshipService;
import com.paymybuddy.paymybuddy.services.TransactionService;
import com.paymybuddy.paymybuddy.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FrontEndController {

    private final TransactionService transactionService;
    private final FriendshipService friendshipService;
    private final UserService userService;

    @Autowired
    public FrontEndController(TransactionService transactionService, FriendshipService friendshipService,
            UserService userService) {
        this.transactionService = transactionService;
        this.friendshipService = friendshipService;
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String getHomeTemplate(@RequestParam(name = "name", required = false, defaultValue = "World") String param,
            Model model) {
        return "home";
    }

    @GetMapping(value = "/transfer")
    public String getTransferTemplate(
            @RequestParam(name = "name", required = false, defaultValue = "World") String param,
            Model model) {
        // Get all Friendships from User ID
        // UserDetails userDetails = (UserDetails)
        // SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // String username = userDetails.getUsername();
        // User user = userService.getUserByUsername(username);
        // int userId = user.getUserId();
        // List<Friendship> friendships =
        // friendshipService.getFriendshipsByUserId(userId);
        List<Friendship> friendships = friendshipService.getFriendshipsByUserId(Integer.valueOf("1"));
        model.addAttribute("friendships", friendships);
        // Get all transactions from User ID
        List<Transaction> transactions = transactionService.getTransactionsByUserId(Integer.valueOf("1"));
        model.addAttribute("transactions", transactions);
        // Get current user from Spring Security
        // List<BankAccount> bankAccounts = bankAccountService.getAllBankAccounts();
        // model.addAttribute("bankAccounts", bankAccounts);
        return "transfer";
    }

}
