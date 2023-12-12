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

    public User getSenderUser() {
        return sender_user_id;
    }

    public void setSenderUser(User sender_user_id) {
        this.sender_user_id = sender_user_id;
    }

    public User getReceiverUser() {
        return receiver_user_id;
    }

    public void setReceiverUser(User receiver_user_id) {
        this.receiver_user_id = receiver_user_id;
    }

    @Column
    public String description;
    @Column(precision = 10, scale = 2)
    public BigDecimal amount;

    @Column
    public LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "sender_user_id", nullable = false)
    public User sender_user_id;

    @ManyToOne
    @JoinColumn(name = "receiver_user_id", nullable = false)
    public User receiver_user_id;

    public Transaction() {
    }
}