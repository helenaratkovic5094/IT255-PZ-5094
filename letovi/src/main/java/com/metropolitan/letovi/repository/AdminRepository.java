package com.metropolitan.letovi.repository;

import com.metropolitan.letovi.entiteti.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
//    Admin findByUsername(String username);
    List<Admin> findByUsername(String username);
}
