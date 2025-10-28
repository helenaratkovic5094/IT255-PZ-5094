package com.metropolitan.letovi.service;


import com.metropolitan.letovi.entiteti.User;
import com.metropolitan.letovi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean authenticate(String username, String password) {
        System.out.println("Authenticating user: " + username);
        List<User> users = userRepository.findByUsername(username);
        System.out.println("Found users: " + users);

        if (users.size() == 1) {
            System.out.println("provera sifre");
            User user = users.get(0);
            System.out.println("User details from database: " + user);
            return user.getPassword().equals(password);
        } else if (users.size() > 1) {
            System.out.println("Multiple users found with the same username. This should not happen.");
        } else {
            System.out.println("No user found with username: " + username);
        }

        return false;
    }

    public List<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}