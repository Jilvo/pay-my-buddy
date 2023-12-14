package com.paymybuddy.paymybuddy.services;

import com.paymybuddy.paymybuddy.models.Transaction;
import com.paymybuddy.paymybuddy.models.User;
import com.paymybuddy.paymybuddy.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TransactionService {

    private TransactionRepository transactionRepository;
    private UserService userService;

    public TransactionService(TransactionRepository transactionRepository, UserService userService) {
        this.transactionRepository = transactionRepository;
        this.userService = userService;
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public List<Transaction> getTransactionsByUserId(Integer user_id) {
        return transactionRepository.findAllById(Collections.singleton(user_id));
    }

    public void createTransaction(Transaction transaction) {
        System.out.println("TransactionService.createTransaction");
        // User senderUser = userService.getUserById(transaction.sender_user_id);
        // Transaction newTransaction = new Transaction(transaction.getSender_id(),
        // transaction.getReceiver_id(),
        // transaction.getAmount(), transaction.getDescription());
    }
}
