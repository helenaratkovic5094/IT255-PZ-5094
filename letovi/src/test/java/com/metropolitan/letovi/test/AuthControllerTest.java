package com.metropolitan.letovi.test;

import com.metropolitan.letovi.controller.AuthController;
import com.metropolitan.letovi.entiteti.Admin;
import com.metropolitan.letovi.service.AuthService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest
public class AuthControllerTest {

    @Mock
    private AuthService authService;

    @InjectMocks
    private AuthController authController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLoginSuccess() {
        Admin loginRequest = new Admin(1, "admin", "password");
        when(authService.authenticate(anyString(), anyString())).thenReturn(true);

        ResponseEntity<?> response = authController.login(loginRequest);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        Map<String, String> expectedResponse = new HashMap<>();
        expectedResponse.put("message", "Login successful");
        assertEquals(expectedResponse, response.getBody());

        verify(authService, times(1)).authenticate(anyString(), anyString());
    }

    @Test
    public void testLoginFailure() {
        Admin loginRequest = new Admin(1, "admin", "wrongpassword");
        when(authService.authenticate(anyString(), anyString())).thenReturn(false);

        ResponseEntity<?> response = authController.login(loginRequest);

        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
        Map<String, String> expectedResponse = new HashMap<>();
        expectedResponse.put("message", "Invalid username or password");
        assertEquals(expectedResponse, response.getBody());

        verify(authService, times(1)).authenticate(anyString(), anyString());
    }
}

