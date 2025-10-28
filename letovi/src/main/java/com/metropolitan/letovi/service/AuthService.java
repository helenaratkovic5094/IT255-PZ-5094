package com.metropolitan.letovi.service;

import com.metropolitan.letovi.entiteti.Admin;
import com.metropolitan.letovi.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {

    @Autowired
    private AdminRepository adminRepository;

    public boolean authenticate(String username, String password) {
        System.out.println("Authenticating user: " + username);
        List<Admin> users = adminRepository.findByUsername(username);
        System.out.println("Found users: " + users);

        if (users.size() == 1) {
            System.out.println("provera sifre");
            Admin user = users.get(0);
            System.out.println("User details from database: " + user);
            return user.getPassword().equals(password);
        } else if (users.size() > 1) {
            System.out.println("Multiple users found with the same username. This should not happen.");
        } else {
            System.out.println("No user found with username: " + username);
        }

        return false;
    }

    public void registerUser(Admin user) {
        List<Admin> users = adminRepository.findByUsername(user.getUsername());
        if (users.isEmpty()) {
            adminRepository.save(user);
        } else {
            throw new RuntimeException("Username already exists");
        }
    }
}
