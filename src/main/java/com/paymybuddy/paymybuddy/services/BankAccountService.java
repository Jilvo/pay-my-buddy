package com.paymybuddy.paymybuddy.services;

import com.paymybuddy.paymybuddy.models.BankAccount;
import com.paymybuddy.paymybuddy.models.User;
import com.paymybuddy.paymybuddy.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BankAccountService {

    private BankAccountRepository bankAccountRepository;

    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public void createBankAccount(User user) {
        BankAccount bankAccount = new BankAccount("test account_number", "test iban", user);
        bankAccountRepository.save(bankAccount);
    }
}
