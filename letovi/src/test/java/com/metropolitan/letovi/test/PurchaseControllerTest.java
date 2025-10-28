package com.metropolitan.letovi.test;

import com.metropolitan.letovi.entiteti.Purchase;
import com.metropolitan.letovi.service.PurchaseService;
import com.metropolitan.letovi.controller.PurchaseController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class PurchaseControllerTest {

    @Mock
    private PurchaseService purchaseService;

    @InjectMocks
    private PurchaseController purchaseController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreatePurchaseSuccess() {
        Purchase purchase = new Purchase(1, "Belgrade", "New York", "2023-06-20T10:15:30", 2, true, 10000.0);
        Purchase savedPurchase = new Purchase(1, "Belgrade", "New York", "2023-06-20T10:15:30", 2, true, 14000.0);

        when(purchaseService.savePurchase(any(Purchase.class))).thenReturn(savedPurchase);

        ResponseEntity<?> response = purchaseController.createPurchase(purchase);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(savedPurchase, response.getBody());

        verify(purchaseService, times(1)).savePurchase(any(Purchase.class));
    }

    @Test
    public void testCreatePurchaseFailure() {
        Purchase purchase = new Purchase(1, "Belgrade", "New York", "2023-06-20T10:15:30", 2, true, 10000.0);

        when(purchaseService.savePurchase(any(Purchase.class))).thenThrow(new RuntimeException("Error"));

        ResponseEntity<?> response = purchaseController.createPurchase(purchase);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("An error occurred while processing the purchase.", response.getBody());

        verify(purchaseService, times(1)).savePurchase(any(Purchase.class));
    }

    @Test
    public void testGetAllKupovine() {
        Purchase purchase1 = new Purchase(1, "Belgrade", "New York", "2023-06-20T10:15:30", 2, true, 14000.0);
        Purchase purchase2 = new Purchase(2, "Belgrade", "Paris", "2023-07-20T10:15:30", 1, false, 5000.0);

        List<Purchase> purchases = Arrays.asList(purchase1, purchase2);

        when(purchaseService.getAllKupovine()).thenReturn(purchases);

        List<Purchase> response = purchaseController.getAllKupovine();

        assertEquals(2, response.size());
        assertEquals(purchase1, response.get(0));
        assertEquals(purchase2, response.get(1));

        verify(purchaseService, times(1)).getAllKupovine();
    }
}
