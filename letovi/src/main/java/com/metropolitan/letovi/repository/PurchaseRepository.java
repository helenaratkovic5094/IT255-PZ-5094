package com.metropolitan.letovi.repository;

import com.metropolitan.letovi.entiteti.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
}
