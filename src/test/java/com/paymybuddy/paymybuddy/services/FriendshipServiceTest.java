package com.paymybuddy.paymybuddy.services;

import com.paymybuddy.paymybuddy.models.Friendship;
import com.paymybuddy.paymybuddy.models.User;
import com.paymybuddy.paymybuddy.repositories.FriendshipRepository;
import com.paymybuddy.paymybuddy.services.FriendshipService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class FriendshipServiceTest {

    @Mock
    private FriendshipRepository friendshipRepository;

    private FriendshipService friendshipService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        friendshipService = new FriendshipService(friendshipRepository);
    }

    @Test
    public void testGetFriendships() {
        Friendship friendship1 = new Friendship();
        Friendship friendship2 = new Friendship();
        when(friendshipRepository.findAll()).thenReturn(Arrays.asList(friendship1, friendship2));

        List<Friendship> result = friendshipService.getFriendships();

        assertEquals(2, result.size());
        verify(friendshipRepository, times(1)).findAll();
    }

    @Test
    public void testGetFriendshipsByUserId() {
        Friendship friendship = new Friendship();
        User user = new User();
        User friend = new User();
        friendship.setUserId(user);
        friendship.setFriendId(friend);
        when(friendshipRepository.findByUserId_Id(1)).thenReturn(Arrays.asList(friendship));

        List<Friendship> result = friendshipService.getFriendshipsByUserId(1);

        assertEquals(1, result.size());
        verify(friendshipRepository, times(1)).findByUserId_Id(1);
    }

    @Test
    public void testCreateFriendship() {
        Friendship friendship = new Friendship();
        friendshipService.createFriendship(friendship);

        verify(friendshipRepository, times(1)).save(friendship);
    }
}