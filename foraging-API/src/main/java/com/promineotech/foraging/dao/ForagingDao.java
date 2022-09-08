package com.promineotech.foraging.dao;

import java.util.List;
import java.util.Optional;
import com.promineotech.foraging.entity.ForagedItem;

public interface ForagingDao {

  List<ForagedItem> fetchForagedItem(String item_type);

  Optional<ForagedItem> deleteForagedItem(Long item_ID);

  Optional<ForagedItem> createForgedItem(String item_name, String item_type, String species_name);

  Optional<ForagedItem> updateForagedItem(Long item_ID, String item_name, String item_type, String species_name);

}
