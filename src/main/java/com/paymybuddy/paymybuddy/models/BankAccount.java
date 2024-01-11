package com.paymybuddy.paymybuddy.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "bank_account")
@JsonIgnoreProperties({ "friendList" })

public class BankAccount implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;

    @Column(name = "account_number")
    public String account_number;

    @Column(unique = true, name = "iban")
    public String iban;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    public User userId;

    public BankAccount(String account_number, String iban, User userId) {
        this.account_number = account_number;
        this.iban = iban;
        this.userId = userId;
    }

    public BankAccount() {
    }

    public Integer getBankAccountId() {
        return id;
    }

    public void setBankAccountId(Integer id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return account_number;
    }

    public void setAccountNumber(String account_number) {
        this.account_number = account_number;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public User getUser() {
        return userId;
    }

    public void setUser(User user) {
        this.userId = user;
    }
}
