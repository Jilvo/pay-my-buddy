package com.paymybuddy.paymybuddy.controllers;

import com.paymybuddy.paymybuddy.models.Transaction;
import com.paymybuddy.paymybuddy.services.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/create_transaction")
    public String createTransaction(@RequestParam("friendship") Integer receiverId,
            @RequestParam("amount") Double amount) {
        System.out.println("TransactionController.createTransaction");
        transactionService.createTransaction(transaction);
        return "transfer";
    }
}
