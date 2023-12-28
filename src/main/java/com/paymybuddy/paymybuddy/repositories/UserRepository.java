package com.paymybuddy.paymybuddy.repositories;

import com.paymybuddy.paymybuddy.models.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.id != :userId")
    List<User> getUnconnectedUsers(@Param("userId") int userId);
}
