package com.paymybuddy.paymybuddy.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public User getSender_user() {
        return senderUser;
    }

    public void setSender_user(User senderUser) {
        this.senderUser = senderUser;
    }

    public User getReceiver_user() {
        return receiverUser;
    }

    public void setReceiver_user(User receiverUser) {
        this.receiverUser = receiverUser;
    }

    @Column
    public String description;
    @Column(precision = 10, scale = 2)
    public BigDecimal amount;

    @Column
    public LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "sender_user", nullable = false)
    public User senderUser;

    @ManyToOne
    @JoinColumn(name = "receiver_user", nullable = false)
    public User receiverUser;

    public Transaction() {
    }

    public Transaction(String description, BigDecimal amount, User senderUser, User receiverUser) {
        this.description = description;
        this.amount = amount;
        this.date = LocalDateTime.now();
        this.senderUser = senderUser;
        this.receiverUser = receiverUser;

    }
}