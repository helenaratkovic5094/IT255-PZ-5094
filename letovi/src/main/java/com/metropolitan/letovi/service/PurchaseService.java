package com.metropolitan.letovi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.metropolitan.letovi.entiteti.Purchase;
import com.metropolitan.letovi.repository.PurchaseRepository;

import java.util.List;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public Purchase savePurchase(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }
    public List<Purchase> getAllKupovine() {
        return purchaseRepository.findAll();
    }
}

