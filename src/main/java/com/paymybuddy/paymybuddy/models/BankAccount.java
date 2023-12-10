package com.paymybuddy.paymybuddy.models;

import jakarta.persistence.*;

@Entity
@Table(name = "bank_account")
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bank_account_id")
    public Integer bank_account_id;

    @Column(name = "account_number")
    public String account_number;

    @Column(unique = true, name = "iban")
    public String iban;

    public Integer getBankAccountId() {
        return bank_account_id;
    }

    public void setBankAccountId(Integer bankAccountId) {
        this.bank_account_id = bankAccountId;
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
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    public User user;
}
