package com.paymybuddy.paymybuddy.services;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.paymybuddy.paymybuddy.models.User;
import com.paymybuddy.paymybuddy.repositories.UserRepository;

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

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> getUnconnectedUsers(int userId) {
        List<User> users = userRepository.findAll();
        users.removeIf(user -> user.getUserId() == userId);

        return userRepository.getUnconnectedUsers(userId);
    }

    public void decrementBalance(User sender_user, BigDecimal amount) {
        BigDecimal sender_balance = sender_user.getBalance();
        sender_balance = sender_balance.subtract(amount);
        sender_user.setBalance(sender_balance);
        userRepository.save(sender_user);
    }

    public void incrementBalance(User receiverUser, BigDecimal amount) {
        BigDecimal receiver_balance = receiverUser.getBalance();
        receiver_balance = receiver_balance.add(amount);
        receiverUser.setBalance(receiver_balance);
        userRepository.save(receiverUser);
    }

    public Boolean checkCurrentBalance(User sender_user, BigDecimal amount) {
        BigDecimal sender_balance = sender_user.getBalance();
        if (sender_balance.compareTo(amount) < 0) {
            return false;
        } else {
            return true;
        }
    }
}
