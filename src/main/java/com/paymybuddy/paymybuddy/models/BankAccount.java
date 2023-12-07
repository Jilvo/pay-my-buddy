package com.paymybuddy.paymybuddy.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer bankAccountId;

    @Column
    public String accountNumber;

    @Column(unique = true)
    public String iban;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    public User user;
}
