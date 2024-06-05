package com.saintjulienbeychevelle.market.service;

import com.saintjulienbeychevelle.market.entity.User;
import com.saintjulienbeychevelle.market.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }
}
