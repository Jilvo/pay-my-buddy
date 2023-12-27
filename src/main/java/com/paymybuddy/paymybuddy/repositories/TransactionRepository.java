package com.paymybuddy.paymybuddy.repositories;

import com.paymybuddy.paymybuddy.models.Transaction;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findBySenderUser_Id(@Param("senderUserId") Integer senderUserId);
}
