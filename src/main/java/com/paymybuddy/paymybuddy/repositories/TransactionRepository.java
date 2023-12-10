package com.paymybuddy.paymybuddy.repositories;

import com.paymybuddy.paymybuddy.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
