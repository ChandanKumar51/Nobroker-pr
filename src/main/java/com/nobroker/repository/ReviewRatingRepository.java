package com.nobroker.repository;

import com.nobroker.entity.ReviewRating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRatingRepository extends JpaRepository<ReviewRating, Long> {
    // Add custom query methods if needed
}
