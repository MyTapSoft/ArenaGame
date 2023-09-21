package org.example.characters.location;

import java.util.ArrayList;
import java.util.List;
import org.example.characters.hero.Hero;
import org.example.ui.UserInputHandler;

public class Hospital extends AbstractLocation {

  @Override
  public String getLocationName() {
    return "Hospital";
  }

  @Override
  public String getLocationId() {
    return "3";
  }

  @Override
  public List<AbstractLocation> getPaths() {
    List<AbstractLocation> possibleMoves = new ArrayList<>();
    for (AbstractLocation location : Location.getAllLocations()) {
      if (location.getLocationId().equals("1")) {
        possibleMoves.add(location);
      }
    }
    return possibleMoves;
  }

  @Override
  public void interact(Hero hero) {
    boolean isLocationChanged = false;
    System.out.println("Вы в госпитале и бла бла бла");
    while (!isLocationChanged) {
      System.out.println("Что делаем?");
      System.out.println("1 - Лечимся");
      System.out.println("2 - Уходим");
      String answer = UserInputHandler.getUserInput();
      if (answer.equalsIgnoreCase("1")) {
        fullHeal(hero);
        System.out.println("Исцелен");
      } else if (answer.equalsIgnoreCase("2")) {
        System.out.println("Куда?");
        for (AbstractLocation path : getPaths()) {
          System.out.println(path.getLocationId() + ": " + path.getLocationName());
        }
        String answer2 = UserInputHandler.getUserInput();
        for (AbstractLocation path : getPaths()) {
          if (answer2.equals(path.getLocationId())){
            hero.setCurrentLocation(path);
            isLocationChanged = true;
            break;
          }
        }
      }
    }
  }

  private void fullHeal(Hero hero) {
    hero.setCurrentHp(hero.getMaxHp());
    hero.setCurrentMp(hero.getMaxMp());
    System.out.println("Персонаж полность здоров");
  }

  private void fullHealHP(Hero hero) {
    hero.setCurrentHp(hero.getMaxHp());
  }

  private void fullRechargeMP(Hero hero) {
    hero.setCurrentMp(hero.getMaxMp());
  }
}
