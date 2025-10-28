package com.metropolitan.letovi.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.metropolitan.letovi.entiteti.Review;
import com.metropolitan.letovi.service.ReviewService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class ReviewControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReviewService reviewService;

    private List<Review> mockReviews;

    @BeforeEach
    public void setUp() {
        // Inicijalizacija mock objekta reviewService
        MockitoAnnotations.initMocks(this);

        // Postavka ponašanja za metod addReview()
        when(reviewService.addReview(any(Review.class))).thenAnswer(invocation -> {
            Review review = invocation.getArgument(0);
            review.setId(1); // Postavka id-ja (primer)
            return review;
        });
    }


//    @Test
//    public void testGetAllReviews() throws Exception {
//        // Perform GET request and verify results
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/reviews"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].user").value("User1"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[1].user").value("User2"));
//    }

    @Test
    public void testAddReview() throws Exception {
        Review newReview = new Review();
        newReview.setUser("NewUser");
        newReview.setContent("New review content");
        newReview.setRating(4);

        // Perform POST request and verify result
        mockMvc.perform(MockMvcRequestBuilders.post("/api/reviews")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(newReview)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user").value("NewUser"));
    }

    // Helper method to convert object to JSON string
    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

