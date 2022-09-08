package com.promineotech.foraging.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.foraging.entity.Location;
import com.promineotech.foraging.service.ForagingService;
import com.promineotech.foraging.service.LocationService;

@RestController
public class BasicLocationController implements LocationController {

  @Autowired
  private LocationService locationService;
  
  @Override
  public List<Location> fetchLocations(String Season) {
    return locationService.fetchLocations( Season);
  }

  @Override
  public Optional<Location> createNewLocation(String Country, String Region, String Season) {
        return locationService.createNewLocation(Country, Region, Season);
  }

//  @Override
//  public Optional<Location> updateLocation(String Country, String Region, String Season) {
//        return locationService.updateLocation(Country, Region, Season);
//  }
  
}
