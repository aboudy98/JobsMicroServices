package com.embarkx.reviewms.Revirwes;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReview(Long companyId);
    Review createReview(Review review, Long companyId) throws Exception;
    Review getReviewById(Long reviewId) throws Exception;
    Review UpdateReviewByComapnyId(Long reviewId,  Review review) throws Exception;
    void deleteReview(Long reviewId) throws Exception;
    
}
