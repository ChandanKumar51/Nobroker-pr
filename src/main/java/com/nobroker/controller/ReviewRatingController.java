package com.nobroker.controller;

import com.nobroker.entity.ReviewRating;
import com.nobroker.service.ReviewRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reviews")
public class ReviewRatingController {

    @Autowired
    private ReviewRatingService reviewRatingService;

    //http://localhost:8080/api/reviews/rating
    @PostMapping("/rating")
    public ResponseEntity<ReviewRating> addReviewRating(@RequestBody ReviewRating reviewRating) {
        ReviewRating savedReviewRating = reviewRatingService.addReviewRating(reviewRating);
        return new ResponseEntity<>(savedReviewRating, HttpStatus.CREATED);
    }

    // Add other endpoints for updating, deleting, and retrieving reviews and ratings
}
