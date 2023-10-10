package org.example.characters.location;

import java.util.ArrayList;
import java.util.List;
import org.example.characters.location.impl.Arena;
import org.example.characters.location.impl.DefaultLocation;
import org.example.characters.location.impl.Hospital;
import org.example.characters.location.impl.Store;

public class Location {

  private static final List<AbstractLocation> locations = new ArrayList<>();

  static {
    Hospital hospital = new Hospital();
    Arena arena = new Arena();
    DefaultLocation defaultLocation = new DefaultLocation();
    Store store = new Store();

    locations.add(hospital);
    locations.add(arena);
    locations.add(defaultLocation);
    locations.add(store);
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
