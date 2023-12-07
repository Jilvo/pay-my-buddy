package com.paymybuddy.paymybuddy.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paymybuddy.paymybuddy.models.User;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class Authentication {
    @PostMapping("login")
    public ResponseEntity<String> loginUser(@RequestBody String email, @RequestBody String password) {

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Logged Successfully");
    }

    @PostMapping("register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Registered Successfully");
    }

}
