package org.example.characters.location.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.example.GameStarter;
import org.example.characters.enemy.Enemy;
import org.example.characters.enemy.impl.DarkOrc;
import org.example.characters.hero.Hero;
import org.example.characters.location.AbstractLocation;
import org.example.characters.location.Location;
import org.example.ui.DialoguesAndMessages;
import org.example.ui.UserInputHandler;

public class Arena extends AbstractLocation {
    DialoguesAndMessages diam = new DialoguesAndMessages();

    public void acquireExperience(Hero hero, Enemy enemy) {
        double exp = enemy.getEXPcount();
        double heroExp = hero.getEXPcount();
        hero.setEXPcount(exp + heroExp);
    }

    public void acquireSkillPoint(Hero hero, Enemy enemy) {
        double sp = enemy.getSPcount();
        double heroSp = hero.getSPcount();
        hero.setSPcount(sp + heroSp);
    }

    private List<Enemy> generateEnemies(int enemiesAmount) {
        List<Enemy> enemies = new ArrayList<>();
        for (int i = 0; i < enemiesAmount; i++) {
            Enemy enemy = DarkOrc.buildDefaultOrc();
            enemies.add(enemy);
        }
        return enemies;
    }

    private List<Enemy> generateEnemiesByGameDifficult(int difficult) {
        List<Enemy> enemies = new ArrayList<>();

        switch (difficult) {
            case 1 -> enemies.addAll(generateEnemies(3));
            case 2 -> enemies.addAll(generateEnemies(5));
            case 3 -> enemies.addAll(generateEnemies(8));
            default -> throw new RuntimeException("Неизвестный уровень сложности: " + difficult);
        }
        return enemies;
    }

    public boolean extraBeat() {
        Random random = new Random();
        int rnd = random.nextInt(100);
        if (rnd < 10) {
            System.out.println("Дополнительный удар!");
            return true;
        }
        return false;
    }

    public void startFight(Hero hero) {
        System.out.println("Выберите уровень сложности врагов.\n" +
                "Всего доступно 3 уровня сложности.\n" +
                "Введите соответствующую цифру в консоль.");
        String difficultString = UserInputHandler.getUserInput();
        int diff = Integer.parseInt(difficultString);
        List<Enemy> enemies = generateEnemiesByGameDifficult(diff);
        System.out.println("Врагов: " + enemies.size());
        for (Enemy enemy : enemies) {
            System.out.println("Против вас выходит: " + diam.orkNames());
            while (hero.getCurrentHp() > 0 && enemy.getCurrentHp() > 0) {
                System.out.println("1 - атака мечом");
                System.out.println("2 - атака умением");
                String attackString = UserInputHandler.getUserInput();
                if (attackString.equalsIgnoreCase("1")) {
                    hero.attack(enemy);
                    if (extraBeat()) {
                        hero.attack(enemy);
                    }
                    enemy.attack(hero);
                    if (extraBeat()) {
                        enemy.attack(hero);
                    }
                    if (hero.getCurrentHp() <= 0) {
                        System.out.println("Вы проиграли!");
                    }
                    if (enemy.getCurrentHp() <= 0) {
                        acquireExperience(hero, enemy);
                        acquireSkillPoint(hero, enemy);
                        System.out.println("Вы победили!");
                        System.out.println("Получено " + enemy.getEXPcount() + " опыта.");
                        System.out.println("Получено " + enemy.getSPcount() + " очков умений.");
                    }
                }
                if (attackString.equalsIgnoreCase("2")){
                    System.out.println("Выберите умение для атаки");
                    String skillString = UserInputHandler.getUserInput();

                }
            }
        }
    }

    @Override
    public String getLocationName() {
        return "Arena";
    }

    @Override
    public String getLocationId() {
        return "2";
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
        while (!isLocationChanged) {
            System.out.println("Вы входите на Арену");
            System.out.println("Что делаем?");
            System.out.println("1 - Деремся");
            System.out.println("2 - Уходим");
            String answer = UserInputHandler.getUserInput();
            if (answer.equalsIgnoreCase("1")) {
                startFight(hero);
            } else if (answer.equalsIgnoreCase("2")) {
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
            }
        }
    }
}
