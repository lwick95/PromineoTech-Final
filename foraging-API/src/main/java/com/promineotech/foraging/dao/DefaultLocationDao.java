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
import com.promineotech.foraging.entity.Location;

@Component
public class DefaultLocationDao implements LocationDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public List<Location> fetchLocations( String season) {
    
    //@formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM location "
        + "WHERE season = :season";
    //@formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("season", season);
    
    return jdbcTemplate.query(sql, params,
        new RowMapper<>() {

          @Override
          public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
            //@formatter:off
            return Location.builder()
                .Location_ID(rs.getLong("Location_ID") )
                .Country(rs.getString("Country"))
                .Region(rs.getString("Region"))
                .Season(rs.getString("Season"))
                .build();
            //@formatter:on
          }});
  }


  @Override
  public Optional<Location> createNewLocation(String country, String region, String season) {
      SqlParams params = generateInsertSql(country, region, season);
    
    KeyHolder keyHolder = new GeneratedKeyHolder();
    
    jdbcTemplate.update(params.sql, params.source, keyHolder);
    
    Long Location_ID = keyHolder.getKey().longValue();
    //  @formatter:off
      return Optional.of(Location.builder()
          .Location_ID(Location_ID)
          .Country(country)
          .Region(region)
          .Season(season)
          .build());
    // @formatter:on
  }

  private SqlParams generateInsertSql(String country, String region, String season) {
    SqlParams params = new SqlParams();
    
    // @formatter:off
    params.sql = ""
        + "INSERT INTO location ("
        + "Country, Region, Season"
        + ") VALUES ("
        + ":country, :region, :season"
        + ")";
    // @formatter:on
    
    params.source.addValue("country", country);
    params.source.addValue("region", region);
    params.source.addValue("season", season);
    
    return params;
  }

//  @Override
//  public Optional<Location> updateLocation(String country, String region, String season) {
//    return Optional.empty();
//  }

}

