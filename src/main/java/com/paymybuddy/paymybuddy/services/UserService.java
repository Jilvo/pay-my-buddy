package com.paymybuddy.paymybuddy.services;

import com.paymybuddy.paymybuddy.models.User;
import com.paymybuddy.paymybuddy.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User createUser(User user) {
        User newUser = new User(user.getFirstName(), user.getLastName(), user.getPassword(), user.getEmail(), user.getBalance(),true,"USER");
        return userRepository.save(newUser);
    }

}
