package com.embarkx.reviewms.Revirwes;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(@RequestParam Long companyId){
        List<Review> reviews = reviewService.getAllReview(companyId);
        if (reviews.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(reviews);

    }

    @PostMapping
    public ResponseEntity<Review> addReview(@RequestBody Review review, @RequestParam Long companyId) throws Exception {
        Review createReview = reviewService.createReview(review, companyId);
        return new ResponseEntity<>(createReview,HttpStatus.CREATED);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> findReviewById(@PathVariable Long reviewId) throws Exception {
       Review review = reviewService.getReviewById(reviewId);
       return ResponseEntity.ok(review);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<Review> updateReview(@PathVariable Long reviewId, 
    @RequestBody Review review) throws Exception {
        Review updatedReview = reviewService.UpdateReviewByComapnyId(reviewId,  review);
        if (updatedReview == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(updatedReview,HttpStatus.OK);

    }
    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long reviewId) throws Exception{
        reviewService.deleteReview(reviewId);

        return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);

    }
    
}
