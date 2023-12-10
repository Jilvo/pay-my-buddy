package com.paymybuddy.paymybuddy.controllers;

import com.paymybuddy.paymybuddy.models.BankAccount;
import com.paymybuddy.paymybuddy.services.BankAccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FrontEndController {

    @GetMapping(value = "/")
    public String getHomeTemplate(@RequestParam(name = "name", required = false, defaultValue = "World") String param,
                              Model model) {
        return "home";
    }
    @GetMapping(value = "/transfer")
    public String getTransferTemplate(@RequestParam(name = "name", required = false, defaultValue = "World") String param,
                              Model model) {
//        BankAccountService bankAccountService = new BankAccountService();
//        List<BankAccount> bankAccounts = bankAccountService.getAllBankAccounts();
//        model.addAttribute("bankAccounts", bankAccounts);
        return "transfer";
    }

}
