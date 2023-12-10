package com.paymybuddy.paymybuddy.controllers;

import com.paymybuddy.paymybuddy.models.Friendship;
import com.paymybuddy.paymybuddy.models.Transaction;
import com.paymybuddy.paymybuddy.services.FriendshipService;
import com.paymybuddy.paymybuddy.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FrontEndController {

    private final TransactionService transactionService;
    private final FriendshipService friendshipService;

    @Autowired
    public FrontEndController(TransactionService transactionService, FriendshipService friendshipService) {
        this.transactionService = transactionService;
        this.friendshipService = friendshipService;
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
        List<Friendship> friendships = friendshipService.getFriendshipsByUserId(Integer.valueOf("1"));
        model.addAttribute("friendships", friendships);
        // Get all transactions from User ID
        List<Transaction> transactions = transactionService.getTransactionsByUserId(Integer.valueOf("1"));
        model.addAttribute("transactions", transactions);
//        List<BankAccount> bankAccounts = bankAccountService.getAllBankAccounts();
//        model.addAttribute("bankAccounts", bankAccounts);
        return "transfer";
    }

}
