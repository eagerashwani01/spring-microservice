package com.ashwani.reviewms.review;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// In Monolith: GetAll, Post :: "/company/{companyId}/reviews"
//              Get, Put, Delete :: "/company/{companyId}/reviews/{reviewId}"

// In Microservice: GetAll, Post :: "/reviews?companyId={companyId}"
//                  Get, Put, Delete :: "/reviews/{reviewId}"

@RestController
@RequestMapping("/reviews")
@Tag(name = "Review Controller")
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @Operation(summary = "GET all reviews by company id")
    @GetMapping
    public ResponseEntity<?> getAllReviews(@RequestParam Long companyId){
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
      
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<?> getReview( @PathVariable Long reviewId){
       return new ResponseEntity<>(reviewService.getReview(reviewId), HttpStatus.OK);
     
    }

    @PostMapping
    public ResponseEntity<String> addReview(@RequestParam Long companyId, @RequestBody Review review) {
        boolean isReviewSaved = reviewService.addReview(companyId, review);

        if(isReviewSaved){
            return new ResponseEntity<>("Review Added Successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Review not saved", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("{reviewId}")
    public ResponseEntity<String> updateReview( @PathVariable Long reviewId, @RequestBody Review review){
        boolean isUpdated = reviewService.updateReview(reviewId, review);

        if(isUpdated)
            return new ResponseEntity<>("Review Updated successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Review not updated", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long reviewId){
        boolean isDeleted = reviewService.deleteReview(reviewId);
        if(isDeleted)
            return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Review not deleted", HttpStatus.BAD_REQUEST);
    }
}
