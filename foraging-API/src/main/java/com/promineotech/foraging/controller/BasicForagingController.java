package com.promineotech.foraging.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.foraging.entity.ForagedItem;
import com.promineotech.foraging.service.ForagingService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BasicForagingController implements ForagingController {

  @Autowired
  private ForagingService foragingService;
  
  @Override
  public Optional<ForagedItem> createNewItem(String item_name, String item_type,
      String species_name) {
    return foragingService.createForgedItem(item_name, item_type, species_name);
  }

  @Override
  public Optional<ForagedItem> updateItem(Long item_ID, String item_name, String item_type, String species_name) {
    return foragingService.updateForagedItem(item_ID, item_name, item_type, species_name);
  }

  @Override
  public List<ForagedItem> fetchForagedItem( String item_type) {
    log.info("item_type={}",item_type);
    return foragingService.fetchForagedItem(item_type);
  }

  @Override
  public Optional<ForagedItem> deleteItem(Long item_ID) {
    return foragingService.deleteForagedItem(item_ID);
  }



}
