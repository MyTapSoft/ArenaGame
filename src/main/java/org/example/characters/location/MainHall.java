package org.example.characters.location;

import org.example.GameStarter;
import org.example.characters.hero.Hero;
import org.example.characters.hero.HeroBuilder;
import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Scanner;

public class MainHall {
    String consoleRead;
    GameStarter gs = new GameStarter();
    Hospital hospital = new Hospital();
    Scanner scanner = new Scanner(System.in);

    public void intersection(Hero hero) {
        System.out.println("Добро пожаловать на главную площадь!\n" +
                "    Куда пойдем?\n" +
                "    1 - Арена;\n" +
                "    2 - Госпиталь;\n" +
                "    3 - Тренировочный зал;\n" +
                "    4 - Магазин.\n" +
                "    exit - выйти из игры. \n" +
                "    (для перехода введите соответствующую цифру в консоль)");
        consoleRead = scanner.nextLine();
        while (!consoleRead.equals("exit")) {

            switch (consoleRead) {
                case "1" -> {
                    System.out.println("Добро пожаловать на Арену.\n" +
                            "Выберите противника.");
                    GameStarter gameStarter = new GameStarter();
                    gameStarter.start();
                }
                case "2" -> {
                    System.out.println("Добро пожаловать в Госпиталь.\n" +
                            "1 - Полное лечение персонажа. \n" +
                            "2 - Полное восстановление HP. \n" +
                            "3 - Полное восстановление MP. \n" +
                            "exit - Выход в главный зал.");
                    String healLine = gs.readLineFromConsole();
                    switch (healLine) {
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
            }
        }
    }

}
