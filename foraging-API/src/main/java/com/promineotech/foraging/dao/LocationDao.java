package com.promineotech.foraging.dao;

import java.util.List;
import java.util.Optional;
import com.promineotech.foraging.entity.Location;

public interface LocationDao {

  List<Location> fetchLocations(String season);

  Optional<Location> createNewLocation(String country, String region, String season);

//  Optional<Location> updateLocation(String country, String region, String season);

}
