package com.metropolitan.letovi.controller;

import com.metropolitan.letovi.entiteti.Purchase;
import com.metropolitan.letovi.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/purchases")
@CrossOrigin(origins = "http://localhost:4200")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping
    public ResponseEntity<?> createPurchase(@Valid @RequestBody Purchase purchase) {
        try {
            // Logging the received purchase object
            System.out.println("Received purchase request: " + purchase);

            // Calculate the additional baggage cost
            double dodatakZaPrtljag = purchase.getZeljeniPrtljag() ? 2000 : 0;

            // Ensure the calculation of the total price is correct
            double ukupnaCena;
            if (isPricePerPassenger(purchase)) {
                ukupnaCena = (purchase.getBrojPutnika() * purchase.getUkupnaCena()) + dodatakZaPrtljag;
            } else {
                ukupnaCena = purchase.getUkupnaCena() + dodatakZaPrtljag;
            }

            // Set the calculated total price
            purchase.setUkupnaCena(ukupnaCena);

            // Save and return the purchase
            Purchase savedPurchase = purchaseService.savePurchase(purchase);
            return new ResponseEntity<>(savedPurchase, HttpStatus.CREATED);

        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            return new ResponseEntity<>("An error occurred while processing the purchase.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Implement this method to determine if the price is per passenger or total
    private boolean isPricePerPassenger(Purchase purchase) {
        // Logic to determine if ukupnaCena is per passenger
        // This could be based on a flag or another field in the Purchase entity
        return true; // Placeholder logic
    }
    @GetMapping
    public List<Purchase> getAllKupovine() {
        return purchaseService.getAllKupovine();
    }
}
