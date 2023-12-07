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
    public Integer userId;

    @Column
    public String firstName;
    @Column
    public String lastName;
    @Column
    public String password;
    @Column
    public String email;

    @Column(precision = 10, scale = 2)
    public BigDecimal balance;

    @Column
    public Boolean enabled;
    @Column
    public String role;

    @ManyToMany
    public List<User> listOfFriends;

}