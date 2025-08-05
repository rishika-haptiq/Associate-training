package com.rishika.BlogHere.controller;

import com.rishika.BlogHere.model.User;
import com.rishika.BlogHere.services.UserServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userServices.createUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userServices.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userServices.getUserById(id);
    }
}
