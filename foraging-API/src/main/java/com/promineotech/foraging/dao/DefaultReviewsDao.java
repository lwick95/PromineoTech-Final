package com.promineotech.foraging.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.promineotech.foraging.entity.ForagedItem;
import com.promineotech.foraging.entity.Reviews;

@Component
public class DefaultReviewsDao implements ReviewsDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

//  @Override
//  public Optional<Reviews> deleteReview(Long review_ID) {
//    return Optional.empty();
//  }

  @Override
  public Optional<Reviews> createNewReview(Long item_ID, String description, String edibility) {
    SqlParams params = generateInsertSql(item_ID, description, edibility);
    
    KeyHolder keyHolder = new GeneratedKeyHolder();
    
    jdbcTemplate.update(params.sql, params.source, keyHolder);
    
    Long review_ID = keyHolder.getKey().longValue();
    //  @formatter:off
      return Optional.of(Reviews.builder()
          .review_ID(review_ID)
          .item_ID(item_ID)
          .description(description)
          .edibility(edibility)
          .build());
    // @formatter:on
  }

  private SqlParams generateInsertSql(Long item_ID, String description, String edibility) {
    SqlParams params = new SqlParams();
    
    // @formatter:off
    params.sql = ""
        + "INSERT INTO reviews ("
        + "item_ID, description, edibility"
        + ") VALUES ("
        + ":item_ID, :description, :edibility"
        + ")";
    // @formatter:on
    
    params.source.addValue("item_ID", item_ID);
    params.source.addValue("description", description);
    params.source.addValue("edibility", edibility);
    
    return params;
  }
  @Override
  public List<Reviews> fetchReviews(Long item_ID) {
    
    //@formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM reviews "
        + "WHERE item_ID = :item_ID";
    //@formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("item_ID", item_ID);
    
    return jdbcTemplate.query(sql, params,
        new RowMapper<>() {

          @Override
          public Reviews mapRow(ResultSet rs, int rowNum) throws SQLException {
            //@formatter:off
            return Reviews.builder()
                .review_ID(rs.getLong("review_ID") )
                .item_ID(rs.getLong("item_ID"))
                .description(rs.getString("description"))
                .edibility(rs.getString("edibility"))
                .build();
            //@formatter:on
          }});
  }
}
