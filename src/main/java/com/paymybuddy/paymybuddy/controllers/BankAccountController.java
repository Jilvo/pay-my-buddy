package com.paymybuddy.paymybuddy.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paymybuddy.paymybuddy.models.BankAccount;
import com.paymybuddy.paymybuddy.services.BankAccountService;

@RestController
public class BankAccountController {

    private final BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    // @GetMapping("/bank-accounts")
    // public List<BankAccount> getAllBankAccounts() {
    // return bankAccountService.getAllBankAccounts();
    // }
}
