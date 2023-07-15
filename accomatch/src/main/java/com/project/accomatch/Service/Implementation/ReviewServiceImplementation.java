package com.project.accomatch.Service.Implementation;

import com.project.accomatch.Model.Review;
import com.project.accomatch.Repository.ReviewRepository;
import com.project.accomatch.Service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImplementation implements ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewServiceImplementation(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    /*@Override
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }*/


    @Override
    public List<Review> getAllReviews(int application_id) {
        return reviewRepository.getAllReviews(application_id);
    }

    @Override
    public Review createReview(Review review){
        Review newReview = new Review(1,2,3,"Gowri",5,"hello");
        newReview = review;
        return newReview;
    }

    // Implement other methods for retrieving, updating, deleting reviews
}
