package org.example.characters.location;

import java.util.ArrayList;
import java.util.List;
import org.example.characters.location.impl.Arena;
import org.example.characters.location.impl.DefaultLocation;
import org.example.characters.location.impl.Hospital;

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
