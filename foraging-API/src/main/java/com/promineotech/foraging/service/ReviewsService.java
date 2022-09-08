package com.promineotech.foraging.service;

import java.util.List;
import java.util.Optional;
import com.promineotech.foraging.entity.ForagedItem;
import com.promineotech.foraging.entity.Reviews;

public interface ReviewsService {

  List<Reviews> fetchReviews(Long item_ID);

  Optional<Reviews> createNewReview(Long item_ID, String description, String edibility);

//  Optional<Reviews> deleteReview(Long review_ID);

}
