package com.promineotech.foraging.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.promineotech.foraging.entity.ForagedItem;


@Component
public class DefaultForagingDao implements ForagingDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public List<ForagedItem> fetchForagedItem(String item_type) {
    
    //@formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM forageditem "
        + "WHERE item_type = :item_type";
    //@formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("item_type", item_type);
    
    return jdbcTemplate.query(sql, params,
        new RowMapper<>() {

          @Override
          public ForagedItem mapRow(ResultSet rs, int rowNum) throws SQLException {
            //@formatter:off
            return ForagedItem.builder()
                .item_ID(rs.getLong("item_ID") )
                .item_name(rs.getString("item_name"))
                .item_type(rs.getString("item_type"))
                .species_name(rs.getString("species_name"))
                .build();
            //@formatter:on
          }});
  }

  @Override
  public Optional<ForagedItem> deleteForagedItem(Long item_ID) {
 SqlParams params = generateDeleteSql(item_ID);
    
    KeyHolder keyHolder = new GeneratedKeyHolder();
    
    jdbcTemplate.update(params.sql, params.source, keyHolder);
    
    //Long item_ID = keyHolder.getKey().longValue();
    //  @formatter:off
      return Optional.of(ForagedItem.builder()
          .item_ID(item_ID)
          .build());
    // @formatter:on
  }

  private SqlParams generateDeleteSql(Long item_ID ) {
    SqlParams params = new SqlParams();
    
    // @formatter:off
    params.sql = ""
        + "DELETE FROM forageditem "
        + "WHERE item_ID = :item_ID"
        + "";
    // @formatter:on
    
    params.source.addValue("item_ID", item_ID);
    
    return params;
  }


  @Override
  public Optional<ForagedItem> createForgedItem(String item_name, String item_type, String species_name) {
    SqlParams params = generateInsertSql(item_name, item_type, species_name);
    
    KeyHolder keyHolder = new GeneratedKeyHolder();
    
    jdbcTemplate.update(params.sql, params.source, keyHolder);
    
    Long item_ID = keyHolder.getKey().longValue();
    //  @formatter:off
      return Optional.of(ForagedItem.builder()
          .item_ID(item_ID)
          .item_name(item_name)
          .item_type(item_type)
          .species_name(species_name)
          .build());
    // @formatter:on
  }

  private SqlParams generateInsertSql(String item_name, String item_type,String species_name ) {
    SqlParams params = new SqlParams();
    
    // @formatter:off
    params.sql = ""
        + "INSERT INTO forageditem ("
        + "item_name, item_type"
        + ") VALUES ("
        + ":item_name, :item_type"
        + ")";
    // @formatter:on
    
    params.source.addValue("item_name", item_name);
    params.source.addValue("item_type", item_type);
    params.source.addValue("species_name", species_name);
    
    return params;
  }

  @Override
  public Optional<ForagedItem> updateForagedItem(Long item_ID, String item_name, String item_type, String species_name) {
   SqlParams params = generateUpdateSql(item_ID, item_name, item_type, species_name);
    
    KeyHolder keyHolder = new GeneratedKeyHolder();
    
    jdbcTemplate.update(params.sql, params.source, keyHolder);
    
   // Long item_ID = keyHolder.getKey().longValue();
    //  @formatter:off
      return Optional.of(ForagedItem.builder()
          .item_ID(item_ID)
          .item_name(item_name)
          .item_type(item_type)
          .species_name(species_name)
          .build());
    // @formatter:on
  }

  private SqlParams generateUpdateSql(Long item_ID, String item_name, String item_type, String species_name) {
    SqlParams params = new SqlParams();
    
    // @formatter:off
    params.sql = ""
        +"UPDATE forageditem "
        +"SET item_name = :item_name, item_type = :item_type, species_name = :species_name "
        +"WHERE item_ID = :item_ID"
        + "";
    // @formatter:on
    
    params.source.addValue("item_ID", item_ID);
    params.source.addValue("item_name", item_name);
    params.source.addValue("item_type", item_type);
    params.source.addValue("species_name", species_name);
    
    return params;
  }

}

class SqlParams {
  String sql;
  MapSqlParameterSource source = new MapSqlParameterSource();
}
