package com.paymybuddy.paymybuddy.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/login")
public class LoginController {
    private static final Logger logger = LogManager.getLogger(LoginController.class);

    @PostMapping("path")
    public SomeEnityData postMethodName(@RequestBody SomeEnityData entity) {
        // TODO: process POST request

        return entity;
    }

}
