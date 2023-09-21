package org.example.characters.location;

import java.util.ArrayList;
import java.util.List;

public class Location {

  private static final List<AbstractLocation> locations = new ArrayList<>();

  static {
    Hospital hospital = new Hospital();
    Arena arena = new Arena();
    DefaultLocation defaultLocation = new DefaultLocation();

    locations.add(hospital);
    locations.add(arena);
    locations.add(defaultLocation);
  }

  public static List<AbstractLocation> getAllLocations() {
    return locations;
  }

  public static AbstractLocation getLocationById(String id) {
    for (AbstractLocation location : locations) {
      if (location.getLocationId().equals(id)) {
        return location;
      }
    }
    return null;
  }

}
