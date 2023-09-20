package org.example.characters.location;

import java.util.List;
import org.example.characters.hero.Hero;
import org.example.ui.UserInputHandler;


public class DefaultLocation extends Location {

  public void intersection(Hero hero) {
    System.out.println("Добро пожаловать на главную площадь!\n" +
        "    Куда пойдем?\n" +
        "    1 - Арена;\n" +
        "    2 - Госпиталь;\n" +
        "    3 - Тренировочный зал;\n" +
        "    4 - Магазин.\n" +
        "    exit - выйти из игры. \n" +
        "    (для перехода введите соответствующую цифру в консоль)");
    String consoleRead = UserInputHandler.getUserInput();
    while (!consoleRead.equals("exit")) {

      switch (consoleRead) {
        case "1" -> {
          System.out.println("Добро пожаловать на Арену.\n" +
              "Выберите противника.");
        }
        case "2" -> {
          System.out.println("Добро пожаловать в Госпиталь.\n" +
              "1 - Полное лечение персонажа. \n" +
              "2 - Полное восстановление HP. \n" +
              "3 - Полное восстановление MP. \n" +
              "exit - Выход в главный зал.");
          String answer = UserInputHandler.getUserInput();
          switch (answer) {
            case "1" -> hospital.fullHeal(hero);
            case "2" -> hospital.fullHealHP(hero);
            case "3" -> hospital.fullRechargeMP(hero);
          }
        }
        case "3" -> {
          System.out.println("Добро пожаловать в Тренировочный зал");
        }
        case "4" -> {
          System.out.println("Добро пожаловать в Магазин");
        }
        default -> {
          System.out.println("Unknown location");
        }
      }
    }
  }

  @Override
  public String getLocationName() {
    return "Main Hall";
  }

  @Override
  public String getLocationId() {
    return "1";
  }

  @Override
  public List<String> getPaths() {
    return List.of("1", "2", "3");
  }
}
