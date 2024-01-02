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

    public BankAccount createBankAccount(String account_number, String iban, User newUser) {
        System.out.println(account_number);
        System.out.println(iban);
        System.out.println(newUser);
        BankAccount newBankAccount = new BankAccount(account_number, iban, newUser);
        return bankAccountRepository.save(newBankAccount);
    }
}
