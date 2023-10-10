package org.example.characters.location.impl;

import java.util.ArrayList;
import java.util.List;
import org.example.characters.hero.Hero;
import org.example.characters.location.AbstractLocation;
import org.example.characters.location.Location;
import org.example.ui.DialoguesAndMessages;
import org.example.ui.UserInputHandler;

public class Hospital extends AbstractLocation {
  DialoguesAndMessages diam = new DialoguesAndMessages();

  @Override
  public String getLocationName() {
    return "Госпиталь.";
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
    System.out.println("Вы в госпитале. Здесь можно восстановить очки здоровья и маны.");
    diam.hospitalFirst();
    while (!isLocationChanged) {

      String answer = UserInputHandler.getUserInput();
      if (answer.equalsIgnoreCase("1")) {
        fullHeal(hero);
        System.out.println("Полностью исцелен");
      } else if(answer.equalsIgnoreCase("2")){
        fullHealHP(hero);
        System.out.println("Здоровье героя полностью восстановлено");
      } else if (answer.equalsIgnoreCase("3")) {
        fullRechargeMP(hero);
        System.out.println("Очки маны героя полностью восстановлены");
      } else if (answer.equalsIgnoreCase("4")) {
        System.out.println("Куда пойдем?");
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
  }

  private void fullHealHP(Hero hero) {
    hero.setCurrentHp(hero.getMaxHp());
  }

  private void fullRechargeMP(Hero hero) {
    hero.setCurrentMp(hero.getMaxMp());
  }
}
