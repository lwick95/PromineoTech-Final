package com.promineotech.foraging.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Reviews {
  private Long review_ID;
  private Long item_ID;
  private String description;
  private String edibility;
  private String availability;
}
