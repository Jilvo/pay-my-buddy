package com.paymybuddy.paymybuddy.services;

import com.paymybuddy.paymybuddy.models.BankAccount;
import com.paymybuddy.paymybuddy.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    public List<BankAccount> getAllBankAccounts() {
        return bankAccountRepository.findAll();
    }
}
