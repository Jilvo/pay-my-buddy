package com.paymybuddy.paymybuddy.models;

import jakarta.persistence.*;

@Entity
@Table(name = "friendship")
public class Friendship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    public User userId;

    @ManyToOne
    @JoinColumn(name = "friendId", nullable = false)
    public User friendId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public User getFriendId() {
        return friendId;
    }

    public void setFriendId(User friendId) {
        this.friendId = friendId;
    }

    public Friendship() {
    }
}
