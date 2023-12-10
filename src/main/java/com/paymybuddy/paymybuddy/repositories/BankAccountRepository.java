package com.paymybuddy.paymybuddy.repositories;

import com.paymybuddy.paymybuddy.models.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, Integer> {

}
