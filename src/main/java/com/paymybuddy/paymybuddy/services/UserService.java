package com.paymybuddy.paymybuddy.services;

import com.paymybuddy.paymybuddy.models.User;
import com.paymybuddy.paymybuddy.repositories.UserRepository;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        User newUser = new User(user.getFirstName(), user.getLastName(), user.getPassword(), user.getEmail(),
                user.getBalance(), true, "USER");
        return userRepository.save(newUser);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Not found!");
        }

        return user;
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(String role) {
        return null;
    }

    public void connect(User user) {
        User user_indb = (User) loadUserByUsername(user.getEmail());
        if (user.getPassword().equals(user_indb.getPassword())) {
            System.out.println("User connected");
        } else {
            System.out.println("Wrong password");
        }
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).get();
    }
}
