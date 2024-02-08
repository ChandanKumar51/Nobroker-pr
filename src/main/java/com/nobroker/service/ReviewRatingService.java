package com.nobroker.service;

import com.nobroker.entity.ReviewRating;
import com.nobroker.repository.ReviewRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewRatingService {

    @Autowired
    private ReviewRatingRepository reviewRatingRepository;

    public ReviewRating addReviewRating(ReviewRating reviewRating) {
        return reviewRatingRepository.save(reviewRating);
    }

    // Add other methods for updating, deleting, and retrieving reviews and ratings
}
