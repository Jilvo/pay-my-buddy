package com.paymybuddy.paymybuddy.controllers;

import com.paymybuddy.paymybuddy.models.Friendship;
import com.paymybuddy.paymybuddy.models.Transaction;
import com.paymybuddy.paymybuddy.models.User;
import com.paymybuddy.paymybuddy.services.FriendshipService;
import com.paymybuddy.paymybuddy.services.TransactionService;
import com.paymybuddy.paymybuddy.services.UserService;

//import jakarta.transaction.Transactional;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

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
        model.addAttribute("user", user);
        int userId = user.getUserId();
        List<Friendship> friendships = friendshipService.getFriendshipsByUserId(userId);
        model.addAttribute("friendships", friendships);

        // Get unconnected users
        List<User> unconnectedUsers = userService.getUnconnectedUsers(userId);

        List<User> usersToRemove = new ArrayList<>();
        for (User user_item : unconnectedUsers) {
            // Loop through each friendship
            for (Friendship friendship : friendships) {
                // If the user is in the friendship, add them to the list of users to be removed
                if (friendship.getFriendId().getUserId() == user_item.getUserId()) {
                    usersToRemove.add(user_item);
                    break;
                }
            }
        }
        // Remove all users in the list of users to be removed from the list of
        // unconnected users
        unconnectedUsers.removeAll(usersToRemove);
        model.addAttribute("unconnectedUsers", unconnectedUsers);
        // Get all transactions from User ID
        List<Transaction> transactions = transactionService.getTransactionsByUserId(userId);
        model.addAttribute("transactions", transactions);

        // Get current user from Spring Security
        // List<BankAccount> bankAccounts = bankAccountService.getAllBankAccounts();
        // model.addAttribute("bankAccounts", bankAccounts);

        return "transfer";
    }

    @PostMapping("/create_transaction")
    // @Transactional
    public RedirectView createTransaction(@RequestParam("friendship") int receiver,
            @RequestParam("amount") BigDecimal amount, @RequestParam("description") String description,
            RedirectAttributes redirectAttributes) {
        User receiverUser = userService.getUserById(receiver);
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = userDetails.getUsername();
        User sender_user = userService.findUserByEmail(email);
        Transaction transaction = new Transaction(description, amount, sender_user, receiverUser);
        Boolean is_balance_enougth = userService.checkCurrentBalance(sender_user, amount);
        if (is_balance_enougth == false) {
            redirectAttributes.addFlashAttribute("error",
                    "Not enough money in your bank account to create transaction");
            return new RedirectView("transfer");
        } else if (amount.compareTo(BigDecimal.ZERO) < 0) {
            redirectAttributes.addFlashAttribute("error",
                    "Cannot create transaction with");
            return new RedirectView("transfer");
        }
        String regex = "^[0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        String amountString = amount.toString();
        Matcher matcher = pattern.matcher(amountString);

        if (matcher.matches()) {
            transactionService.createTransaction(transaction);
            userService.decrementBalance(sender_user, amount);
            BigDecimal fees = new BigDecimal("0.995");
            BigDecimal amount_after_fees = amount.multiply(fees);
            userService.incrementBalance(receiverUser, amount_after_fees);
            return new RedirectView("transfer");
        } else {
            redirectAttributes.addFlashAttribute("error",
                    "Cannot create transaction with");
            return new RedirectView("transfer");
        }

    }
}
