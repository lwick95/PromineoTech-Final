package com.promineotech.foraging.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.foraging.dao.ReviewsDao;
import com.promineotech.foraging.entity.ForagedItem;
import com.promineotech.foraging.entity.Reviews;

@Service
public class DefaultReviewsService implements ReviewsService {

  @Autowired
  private ReviewsDao reviewsDao;
  
  @Override
  public List<Reviews> fetchReviews(Long item_ID) {
    return reviewsDao.fetchReviews(item_ID);
  }

  @Override
  public Optional<Reviews> createNewReview(Long item_ID, String description, String edibility) {
    return reviewsDao.createNewReview(item_ID, description, edibility);
  }

//  @Override
//  public Optional<Reviews> deleteReview(Long review_ID) {
//    return reviewsDao.deleteReview(review_ID);
//  }

}
