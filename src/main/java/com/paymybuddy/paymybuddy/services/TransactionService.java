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

    public List<Transaction> getTransactionsByUserId(int senderUser) {
        return transactionRepository.findBySenderUser_Id(senderUser);
    }

    public void createTransaction(Transaction transaction) {
        System.out.println("TransactionService.createTransaction");
        transactionRepository.save(transaction);
    }
}
