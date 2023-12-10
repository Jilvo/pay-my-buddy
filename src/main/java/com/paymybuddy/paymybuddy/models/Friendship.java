package com.paymybuddy.paymybuddy.models;

import jakarta.persistence.*;

@Entity
@Table(name = "friendship")
public class Friendship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getFriend() {
        return friend;
    }

    public void setFriend(User friend) {
        this.friend = friend;
    }

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    public User user;

    @ManyToOne
    @JoinColumn(name = "friend_id", nullable = false)
    public User friend;
}
