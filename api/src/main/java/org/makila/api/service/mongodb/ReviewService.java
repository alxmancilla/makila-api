package org.makila.api.service.mongodb;

import org.makila.api.model.mongodb.ReviewDocument;
import org.makila.api.repository.mongodb.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    
    public ReviewDocument createReview(ReviewDocument review) {
        return reviewRepository.save(review);
    }
    
    public List<ReviewDocument> getFilmReviews(Long filmId) {
        return reviewRepository.findByFilmId(filmId);
    }
    
    public List<ReviewDocument> getHighRatedReviews(Integer minRating) {
        return reviewRepository.findByRatingGreaterThanEqual(minRating);
    }
}