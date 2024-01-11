package com.paymybuddy.paymybuddy.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "friendship")
public class Friendship implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    public User userId;

    @Getter
    @ManyToOne
    @JoinColumn(name = "friend_id", nullable = false)
    public User friendId;

    public Friendship(User userId, User friendId) {
        this.userId = userId;
        this.friendId = friendId;
    }

    public Friendship() {
    }

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

    public void setFriendId(User friendId) {
        this.friendId = friendId;
    }

}
