package com.paymybuddy.paymybuddy.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;

    public Integer getUserId() {
        return id;
    }

    public void setUserId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

//    public List<User> getListOfFriends() {
//        return listOfFriends;
//    }
//
//    public void setListOfFriends(List<User> listOfFriends) {
//        this.listOfFriends = listOfFriends;
//    }

    @Column
    public String first_name;
    @Column
    public String last_name;
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

//    @ManyToMany
//    public List<User> listOfFriends;

}