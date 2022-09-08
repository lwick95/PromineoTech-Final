package com.promineotech.foraging.service;

import java.util.List;
import java.util.Optional;
import com.promineotech.foraging.entity.Location;

public interface LocationService {

  List<Location> fetchLocations(String season);

  Optional<Location> createNewLocation(String country, String region, String season);

//  Optional<Location> updateLocation(String country, String region, String season);

}
