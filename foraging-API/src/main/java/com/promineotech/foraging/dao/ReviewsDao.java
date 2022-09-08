package com.promineotech.foraging.dao;

import java.util.List;
import java.util.Optional;
import com.promineotech.foraging.entity.ForagedItem;
import com.promineotech.foraging.entity.Reviews;

public interface ReviewsDao {

//  Optional<Reviews> deleteReview(Long review_ID);

  Optional<Reviews> createNewReview(Long item_ID, String description, String edibility);

  List<Reviews> fetchReviews(Long item_ID);

}
