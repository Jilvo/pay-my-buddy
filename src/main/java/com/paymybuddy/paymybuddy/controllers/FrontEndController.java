package com.paymybuddy.paymybuddy.controllers;

import com.paymybuddy.paymybuddy.services.FriendshipService;
import com.paymybuddy.paymybuddy.services.TransactionService;
import com.paymybuddy.paymybuddy.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class FrontEndController {

    private final TransactionService transactionService;
    private final FriendshipService friendshipService;
    private final UserService userService;

    @Autowired
    public FrontEndController(TransactionService transactionService, FriendshipService friendshipService,
            UserService userService) {
        this.transactionService = transactionService;
        this.friendshipService = friendshipService;
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public RedirectView getHomeTemplate(
            @RequestParam(name = "name", required = false, defaultValue = "World") String param,
            Model model) {
        return new RedirectView("transfer");
    }

}
