package org.example.characters.location;

import java.util.ArrayList;
import java.util.List;
import org.example.characters.hero.Hero;
import org.example.ui.UserInputHandler;


public class DefaultLocation extends AbstractLocation {

  @Override
  public String getLocationName() {
    return "Main Hall";
  }

  @Override
  public String getLocationId() {
    return "1";
  }

  @Override
  public List<AbstractLocation> getPaths() {
    List<AbstractLocation> possibleMoves = new ArrayList<>();
    for (AbstractLocation location : Location.getAllLocations()) {
      if (location.getLocationId().equals("2") || location.getLocationId().equals("3")) {
        possibleMoves.add(location);
      }
    }
    return possibleMoves;
  }

  @Override
  public void interact(Hero hero) {
    boolean isLocationChanged = false;
    while (!isLocationChanged) {
      System.out.println("Вы на главной площади");
      System.out.println("Что делаем?");
      System.out.println("1 - Уходим");
      String answer = UserInputHandler.getUserInput();
      if (answer.equalsIgnoreCase("1")) {
        System.out.println("Куда?");
        for (AbstractLocation path : getPaths()) {
          System.out.println(path.getLocationId() + ": " + path.getLocationName());
        }
        String answer2 = UserInputHandler.getUserInput();
        for (AbstractLocation path : getPaths()) {
          if (answer2.equals(path.getLocationId())) {
            hero.setCurrentLocation(path);
            isLocationChanged = true;
            break;
          }
        }
        System.out.println("Unknown location...");
      }
    }
    hero.getCurrentLocation().interact(hero);
  }
}
