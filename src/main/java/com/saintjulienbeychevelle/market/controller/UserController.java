package com.saintjulienbeychevelle.market.controller;

import com.saintjulienbeychevelle.market.entity.User;
import com.saintjulienbeychevelle.market.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
}
