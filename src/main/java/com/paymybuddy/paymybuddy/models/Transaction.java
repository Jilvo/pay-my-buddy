package com.paymybuddy.paymybuddy.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column
    public String description;
    @Column(precision = 10, scale = 2)
    public BigDecimal amount;

    @Column
    public LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "senderUserId", nullable = false)
    public User senderUser;

    @ManyToOne
    @JoinColumn(name = "receiverUserId", nullable = false)
    public User receiverUser;

}