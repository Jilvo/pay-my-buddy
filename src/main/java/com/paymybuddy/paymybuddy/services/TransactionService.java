package com.paymybuddy.paymybuddy.services;

import com.paymybuddy.paymybuddy.models.Transaction;
import com.paymybuddy.paymybuddy.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TransactionService {

    private TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public List<Transaction> getTransactionsByUserId(Integer user_id) {
        return transactionRepository.findAllById(Collections.singleton(user_id));
    }
}
