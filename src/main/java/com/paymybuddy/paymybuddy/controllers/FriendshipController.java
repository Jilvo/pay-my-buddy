package com.paymybuddy.paymybuddy.controllers;

import com.paymybuddy.paymybuddy.services.FriendshipService;

public class FriendshipController {
    private final FriendshipService friendshipService;

    public FriendshipController(FriendshipService friendshipService) {
        this.friendshipService = friendshipService;
    }
}
