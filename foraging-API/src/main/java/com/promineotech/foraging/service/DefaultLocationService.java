package com.promineotech.foraging.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.foraging.dao.LocationDao;
import com.promineotech.foraging.entity.Location;

@Service
public class DefaultLocationService implements LocationService {

  @Autowired
  private LocationDao locationDao;
  
  @Override
  public List<Location> fetchLocations(String season) {
    return locationDao.fetchLocations(season);
  }

  @Override
  public Optional<Location> createNewLocation(String country, String region, String season) {
    return locationDao.createNewLocation(country, region, season);
  }

//  @Override
//  public Optional<Location> updateLocation(String country, String region, String season) {
//    return locationDao.updateLocation(country, region, season);
//  }

}
