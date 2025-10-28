    package com.metropolitan.letovi.controller;

    import com.metropolitan.letovi.entiteti.Review;
    import com.metropolitan.letovi.service.ReviewService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    @RequestMapping("/api/reviews")
    @CrossOrigin(origins = "http://localhost:4200")
    public class ReviewController {
        @Autowired
        private ReviewService reviewService;

        @GetMapping
        public List<Review> getAllReviews() {
            return reviewService.getAllReviews();
        }

        @PostMapping
        public Review addReview(@RequestBody Review review) {
            return reviewService.addReview(review);
        }
    }

