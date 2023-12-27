package com.paymybuddy.paymybuddy.controllers;

import com.paymybuddy.paymybuddy.models.Friendship;
import com.paymybuddy.paymybuddy.models.Transaction;
import com.paymybuddy.paymybuddy.models.User;
import com.paymybuddy.paymybuddy.services.FriendshipService;
import com.paymybuddy.paymybuddy.services.TransactionService;
import com.paymybuddy.paymybuddy.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
public class TransactionController {
    private final TransactionService transactionService;
    private final FriendshipService friendshipService;
    private final UserService userService;

    public TransactionController(TransactionService transactionService, FriendshipService friendshipService,
            UserService userService) {
        this.transactionService = transactionService;
        this.friendshipService = friendshipService;
        this.userService = userService;
    }

    @GetMapping(value = "/transfer")
    public String getTransferTemplate(
            @RequestParam(name = "name", required = false) @PathVariable String Username,
            String param,
            Model model) {
        // Get all Friendships from User ID

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = userDetails.getUsername();
        User user = userService.findUserByEmail(email);
        int userId = user.getUserId();
        List<Friendship> friendships = friendshipService.getFriendshipsByUserId(userId);
        model.addAttribute("friendships", friendships);
        // Get all transactions from User ID
        List<Transaction> transactions = transactionService.getTransactionsByUserId(userId);
        model.addAttribute("transactions", transactions);
        // Get current user from Spring Security
        // List<BankAccount> bankAccounts = bankAccountService.getAllBankAccounts();
        // model.addAttribute("bankAccounts", bankAccounts);
        return "transfer";
    }

    @PostMapping("/create_transaction")
    public RedirectView createTransaction(@RequestParam("friendship") int receiver,
            @RequestParam("amount") BigDecimal amount) {
        User receiverUser = userService.getUserById(receiver);
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = userDetails.getUsername();
        User sender_user = userService.findUserByEmail(email);
        Transaction transaction = new Transaction("test", amount, sender_user, receiverUser);
        System.out.println("TransactionController.createTransaction");
        transactionService.createTransaction(transaction);
        return new RedirectView("transfer");
    }
}
