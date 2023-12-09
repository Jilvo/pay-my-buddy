package com.paymybuddy.paymybuddy.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    @PostMapping("login")
    public ResponseEntity<String> loginUser(@RequestBody String email) {

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Logged Successfully");
    }

    // @PostMapping("register")
    // public ResponseEntity<String> registerUser(@RequestBody User user) {

    // return ResponseEntity.status(HttpStatus.ACCEPTED).body("Registered
    // Successfully");
    // }

}
