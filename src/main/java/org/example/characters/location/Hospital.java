package org.example.characters.location;

import java.util.List;
import org.example.characters.hero.Hero;
import org.example.ui.UserInputHandler;

public class Hospital extends Location {



  @Override
  public String getLocationName() {
    return "Hospital";
  }

  @Override
  public String getLocationId() {
    return "3";
  }

  @Override
  public List<String> getPaths() {
    return List.of("1");
  }

  @Override
  public void interact(Hero hero) {
    System.out.println("Вы в госпитале и бла бла бла");
    System.out.println("Что делаем?");
    System.out.println("1 - Лечимся");
    System.out.println("2 - Уходим");
    String answer = UserInputHandler.getUserInput();
    if (answer.equalsIgnoreCase("1")){
      fullHeal(hero);
    } else if (answer.equalsIgnoreCase("2")) {
      //create enum and use it
      hero.setCurrentLocation(Ma);

    }
  }

  private void fullHeal(Hero hero) {
    hero.fullHeal();
    System.out.println("Персонаж полность здоров");
  }

  private void fullHealHP(Hero hero) {
    hero.setCurrentHp(hero.getMaxHp());
  }

  private void fullRechargeMP(Hero hero) {
    hero.setCurrentMp(hero.getMaxMp());
  }
}
