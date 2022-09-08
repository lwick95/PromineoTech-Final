package com.promineotech.foraging.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Location {
  private Long Location_ID;
  private String Country;
  private String Region;
  private String Season;
}
