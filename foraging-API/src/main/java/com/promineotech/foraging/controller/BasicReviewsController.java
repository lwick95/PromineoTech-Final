package com.promineotech.foraging.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.foraging.entity.ForagedItem;
import com.promineotech.foraging.entity.Reviews;
import com.promineotech.foraging.service.ReviewsService;

@RestController
public class BasicReviewsController implements ReviewsController {

  @Autowired
  private ReviewsService reviewsService;
  
  @Override
  public List<Reviews> fetchReviews(Long item_ID) {
    return reviewsService.fetchReviews(item_ID);
  }

  @Override
  public Optional<Reviews> createNewReview(Long item_ID, String description, String edibility,
      String availability) {
    return reviewsService.createNewReview(item_ID, description, edibility);
  }

//  @Override
//  public Optional<Reviews> deleteReview(Long review_ID) {
//    return reviewsService.deleteReview(review_ID);
//  }
}
