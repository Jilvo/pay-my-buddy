// package com.paymybuddy.paymybuddy.models;

// import java.math.BigDecimal;
// import java.util.List;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.ManyToMany;

// @Entity
// public class User {
// @Id
// @GeneratedValue(strategy = GenerationType.IDENTITY)
// public Integer userId;

// public Integer getUserId() {
// return userId;
// }

// public void setUserId(Integer userId) {
// this.userId = userId;
// }

// public String getFirstName() {
// return firstName;
// }

// public void setFirstName(String firstName) {
// this.firstName = firstName;
// }

// public String getLastName() {
// return lastName;
// }

// public void setLastName(String lastName) {
// this.lastName = lastName;
// }

// public String getPassword() {
// return password;
// }

// public void setPassword(String password) {
// this.password = password;
// }

// public String getEmail() {
// return email;
// }

// public void setEmail(String email) {
// this.email = email;
// }

// public BigDecimal getBalance() {
// return balance;
// }

// public void setBalance(BigDecimal balance) {
// this.balance = balance;
// }

// public Boolean getEnabled() {
// return enabled;
// }

// public void setEnabled(Boolean enabled) {
// this.enabled = enabled;
// }

// public String getRole() {
// return role;
// }

// public void setRole(String role) {
// this.role = role;
// }

// public List<User> getListOfFriends() {
// return listOfFriends;
// }

// public void setListOfFriends(List<User> listOfFriends) {
// this.listOfFriends = listOfFriends;
// }

// @Column
// public String firstName;
// @Column
// public String lastName;
// @Column
// public String password;
// @Column
// public String email;

// @Column(precision = 10, scale = 2)
// public BigDecimal balance;

// @Column
// public Boolean enabled;
// @Column
// public String role;

// @ManyToMany
// public List<User> listOfFriends;

// }