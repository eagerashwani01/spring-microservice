package com.ashwani.reviewms.review.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashwani.reviewms.review.Review;
import com.ashwani.reviewms.review.ReviewRepository;
import com.ashwani.reviewms.review.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService{
    @Autowired
    ReviewRepository reviewRepository;


    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);

        return reviews;
    }

    @Override
    public boolean addReview(Long companyId, Review review) {

        if (companyId != null && review != null) {
            review.setCompanyId(companyId);
            reviewRepository.save(review);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Review getReview(Long reviewId) {
       return reviewRepository.findById(reviewId).orElse(null);
    }

    @Override
    public boolean updateReview(Long reviewId, Review review) {
        Review reviewToUpdate = reviewRepository.findById(reviewId).orElse(null);

        if(review != null){
            reviewToUpdate.setCompanyId(review.getCompanyId());
            reviewToUpdate.setTitle(review.getTitle());
            reviewToUpdate.setDescription(review.getDescription());
            reviewToUpdate.setRating(review.getRating());
            reviewRepository.save(reviewToUpdate);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteReview(Long reviewId) {
        Review review = reviewRepository.findById(reviewId).orElse(null);
        if(review != null){
            reviewRepository.deleteById(reviewId);
            return true;
        } else {
            return false;
        }
    }
}
