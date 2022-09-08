package com.promineotech.foraging.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ForagedItem {
  private Long item_ID;
  private String item_name;
  private String item_type;
  private String species_name;
}
