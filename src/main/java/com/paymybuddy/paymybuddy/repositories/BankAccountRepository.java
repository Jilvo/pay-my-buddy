package com.paymybuddy.paymybuddy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paymybuddy.paymybuddy.models.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, Integer> {

}
