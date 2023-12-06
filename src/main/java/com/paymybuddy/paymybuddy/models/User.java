package com.paymybuddy.paymybuddy.models;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long userId;

    public String firstName;
    public String lastName;
    public String password;
    public String email;

    @Column(precision = 10, scale = 2)
    public BigDecimal balance;

    public Boolean enabled;
    public String role;

    @ManyToMany
    public List<User> listOfFriends;

}