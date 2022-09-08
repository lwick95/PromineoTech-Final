package com.promineotech.foraging.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.foraging.dao.ForagingDao;
import com.promineotech.foraging.entity.ForagedItem;

@Service
public class DefaultForagingService implements ForagingService {

  @Autowired
  private ForagingDao foragingDao;
  
  @Override
  public List<ForagedItem> fetchForagedItem(String item_type) {
    return foragingDao.fetchForagedItem(item_type);
  }

  @Override
  public Optional<ForagedItem> deleteForagedItem(Long item_ID) {
    return foragingDao.deleteForagedItem(item_ID);
  }

  @Override
  public Optional<ForagedItem> updateForagedItem(Long item_ID, String item_name, String item_type,
      String species_name) {
    return foragingDao.updateForagedItem(item_ID, item_name, item_type, species_name);
  }

  @Override
  public Optional<ForagedItem> createForgedItem(String item_name, String item_type,
      String species_name) {
    return foragingDao.createForgedItem(item_name, item_type, species_name);
  }

}
