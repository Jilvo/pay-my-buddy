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
        return user_id;
    }

    public void setUser(User user_id) {
        this.user_id = user_id;
    }

    public User getFriend() {
        return friend_id;
    }

    public void setFriend(User friend_id) {
        this.friend_id = friend_id;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    public User user_id;

    @ManyToOne
    @JoinColumn(name = "friend_id", nullable = false)
    public User friend_id;

    public Friendship() {
    }
}
