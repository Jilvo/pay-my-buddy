package com.paymybuddy.paymybuddy.repositories;

import com.paymybuddy.paymybuddy.models.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendshipRepository extends JpaRepository<Friendship, Integer> {
}
