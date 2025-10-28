package com.metropolitan.letovi.test;

import com.metropolitan.letovi.entiteti.User;
import com.metropolitan.letovi.service.UserService;
import com.metropolitan.letovi.controller.UserController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLoginSuccess() {
        User loginRequest = new User(1, "testuser", "testpassword");
        when(userService.authenticate(anyString(), anyString())).thenReturn(true);

        ResponseEntity<?> response = userController.login(loginRequest);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        Map<String, String> expectedResponse = new HashMap<>();
        expectedResponse.put("message", "Login successful");
        assertEquals(expectedResponse, response.getBody());

        verify(userService, times(1)).authenticate(anyString(), anyString());
    }

    @Test
    public void testLoginFailure() {
        User loginRequest = new User(1, "testuser", "wrongpassword");
        when(userService.authenticate(anyString(), anyString())).thenReturn(false);

        ResponseEntity<?> response = userController.login(loginRequest);

        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
        Map<String, String> expectedResponse = new HashMap<>();
        expectedResponse.put("message", "Invalid username or password");
        assertEquals(expectedResponse, response.getBody());

        verify(userService, times(1)).authenticate(anyString(), anyString());
    }

    @Test
    public void testSignupSuccess() {
        User newUser = new User(1, "newuser", "newpassword");
        when(userService.findByUsername(anyString())).thenReturn(Collections.emptyList());
        when(userService.save(any(User.class))).thenReturn(newUser);

        ResponseEntity<?> response = userController.signup(newUser);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("User registered successfully", response.getBody());

        verify(userService, times(1)).findByUsername(anyString());
        verify(userService, times(1)).save(any(User.class));
    }

    @Test
    public void testSignupFailure() {
        User newUser = new User(1, "existinguser", "newpassword");
        when(userService.findByUsername(anyString())).thenReturn(Collections.singletonList(newUser));

        ResponseEntity<?> response = userController.signup(newUser);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Username already exists", response.getBody());

        verify(userService, times(1)).findByUsername(anyString());
        verify(userService, times(0)).save(any(User.class));
    }

    @Test
    public void testApiWorking() {
        ResponseEntity<String> response = userController.test();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("API is working", response.getBody());
    }
}

