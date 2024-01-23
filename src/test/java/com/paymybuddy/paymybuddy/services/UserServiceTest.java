package com.paymybuddy.paymybuddy.services;

import com.paymybuddy.paymybuddy.models.User;
import com.paymybuddy.paymybuddy.repositories.UserRepository;
import com.paymybuddy.paymybuddy.services.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@example.com");
        user.setPassword("password");
        user.setBalance(new BigDecimal("100.00"));
        user.setEnabled(true);
        user.setRole("USER");

        when(userRepository.save(any(User.class))).thenReturn(user);

        User createdUser = userService.createUser(user);

        assertEquals(user, createdUser);

        assertEquals("John", createdUser.getFirstName());
        assertEquals("Doe", createdUser.getLastName());
        assertEquals("john.doe@example.com", createdUser.getEmail());
        assertEquals(new BigDecimal("100.00"), createdUser.getBalance());
        assertEquals("USER", createdUser.getRole());

        System.out.println(userRepository.findAll());
    }

    @Test
    public void testLoadUserByUsername() {
        System.out.println(userRepository.findAll());
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@example.com");
        user.setPassword("password");
        user.setBalance(new BigDecimal("100.00"));
        user.setEnabled(true);
        user.setRole("USER");

        when(userRepository.findByEmail(anyString())).thenReturn(user);

        User loadedUser = (User) userService.loadUserByUsername("john.doe@example.com");

        assertEquals(user, loadedUser);
        System.out.println(userRepository.findAll());
        verify(userRepository).findByEmail("john.doe@example.com");
    }

    @Test
    public void testLoadUserByUsernameNotFound() {
        when(userRepository.findByEmail(anyString())).thenReturn(null);

        assertThrows(UsernameNotFoundException.class, () -> userService.loadUserByUsername("john.doe@example.com"));
        verify(userRepository).findByEmail("john.doe@example.com");
    }

    @Test
    public void testIsUserExist() {
        User user = new User();
        user.setEmail("test@test.com");
        when(userRepository.findByEmail("test@test.com")).thenReturn(user);

        Boolean result = userService.isUserExist("test@test.com");

        assertTrue(result);
        verify(userRepository, times(1)).findByEmail("test@test.com");
    }

    @Test
    public void testGetUserById() {
        User user = new User();
        user.setUserId(1);
        when(userRepository.findById(1)).thenReturn(Optional.of(user));

        User result = userService.getUserById(1);

        assertEquals(user, result);
        verify(userRepository, times(1)).findById(1);
    }

    @Test
    public void testDecrementBalance() {
        User user = new User();
        user.setBalance(new BigDecimal("100.00"));
        userService.decrementBalance(user, new BigDecimal("50.00"));

        assertEquals(0, user.getBalance().compareTo(new BigDecimal("50.00")));
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void testIncrementBalance() {
        User user = new User();
        user.setBalance(new BigDecimal("100.00"));
        userService.incrementBalance(user, new BigDecimal("50.00"));

        assertEquals(0, user.getBalance().compareTo(new BigDecimal("150.00")));
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void testCheckCurrentBalance() {
        User user = new User();
        user.setBalance(new BigDecimal("100.00"));

        Boolean result = userService.checkCurrentBalance(user, new BigDecimal("50.00"));

        assertTrue(result);
    }
}