package com.embarkx.reviewms.Revirwes.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.embarkx.reviewms.Revirwes.Review;
import com.embarkx.reviewms.Revirwes.ReviewRepository;
import com.embarkx.reviewms.Revirwes.ReviewService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository reviewRepository;
   

    @Override
    public List<Review> getAllReview(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public Review createReview(Review review, Long companyId) throws Exception {
        if(companyId == null){
            throw new Exception("Company not exist");
        }
       
        review.setCompanyId(companyId);
        return reviewRepository.save(review);
    }

    @Override
    public Review getReviewById(Long reviewId) throws Exception {
        Optional<Review> review = reviewRepository.findById(reviewId);
        return review.orElseThrow(() -> new Exception("Review not found with id: " + reviewId));
    }

    @Override
    public Review UpdateReviewByComapnyId(Long reviewId, Review review) throws Exception {

        Review updatedReview = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new Exception("Review not found with id: " + reviewId));
                updatedReview.setTitle(review.getTitle());
                updatedReview.setDescription(review.getDescription());
                updatedReview.setRating(review.getRating());
                return reviewRepository.save(updatedReview);
    }

    @Override
    public void deleteReview(Long reviewId) throws Exception {
       Review review = reviewRepository.findById(reviewId)
                .orElse(null);
        // If the review is not found, throw an exception
       if (review == null) {
            throw new Exception("Review not found with id: " + reviewId);
        }
        reviewRepository.delete(review);
       
    }
}
