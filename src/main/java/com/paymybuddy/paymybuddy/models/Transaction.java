package com.paymybuddy.paymybuddy.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String description;
    public String amount;
    public String date;

    @ManyToOne
    @JoinColumn(name = "senderUserId", nullable = false)
    public User senderUser;

    @ManyToOne
    @JoinColumn(name = "receiverUserId", nullable = false)
    public User receiverUser;

    @ManyToMany
    @JoinColumn(name = "BanAccountId", nullable = false)
    public BankAccount bankAccount;
}