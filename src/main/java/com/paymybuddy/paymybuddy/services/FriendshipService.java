package com.paymybuddy.paymybuddy.services;

import com.paymybuddy.paymybuddy.models.Friendship;
import com.paymybuddy.paymybuddy.models.User;
import com.paymybuddy.paymybuddy.repositories.FriendshipRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class FriendshipService {

    private FriendshipRepository friendshipRepository;

    public FriendshipService(FriendshipRepository friendshipRepository) {
        this.friendshipRepository = friendshipRepository;
    }

    public List<Friendship> getFriendships() {
        return friendshipRepository.findAll();
    }

    public List<Friendship> getFriendshipsByUserId(Integer userId) {
        return friendshipRepository.findByUserId_Id(userId);
    }

    public void createFriendship(Friendship newFriendship) {
        friendshipRepository.save(newFriendship);
    }
}
