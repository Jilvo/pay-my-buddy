package com.paymybuddy.paymybuddy.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.paymybuddy.paymybuddy.models.Friendship;
import com.paymybuddy.paymybuddy.models.User;
import com.paymybuddy.paymybuddy.services.FriendshipService;
import com.paymybuddy.paymybuddy.services.UserService;

@Controller
public class FriendshipController {
    private final FriendshipService friendshipService;
    private final UserService userService;

    public FriendshipController(FriendshipService friendshipService, UserService userService) {
        this.friendshipService = friendshipService;
        this.userService = userService;
    }

    @PostMapping("/create_connection")
    public RedirectView createConnection(@RequestParam("new_friend_id") int new_friend_id) {
        User newFriendId = userService.getUserById(new_friend_id);
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = userDetails.getUsername();
        User currentUser = userService.findUserByEmail(email);
        Friendship newFriendship = new Friendship(currentUser, newFriendId);
        friendshipService.createFriendship(newFriendship);

        return new RedirectView("transfer");
    }

}
