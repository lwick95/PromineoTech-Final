package com.promineotech.foraging.service;

import java.util.List;
import java.util.Optional;
import com.promineotech.foraging.entity.ForagedItem;

public interface ForagingService {

  List<ForagedItem> fetchForagedItem(String item_name);

  Optional<ForagedItem> deleteForagedItem(Long item_ID);

  Optional<ForagedItem> updateForagedItem(Long item_ID, String item_name, String item_type, String species_name);

  Optional<ForagedItem> createForgedItem(String item_name, String item_type, String species_name);

}
