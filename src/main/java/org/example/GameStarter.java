package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.example.characters.enemy.impl.DarkOrc;
import org.example.characters.enemy.Enemy;
import org.example.characters.hero.Hero;
import org.example.characters.hero.HeroBuilder;
import org.example.characters.location.MainHall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

@AllArgsConstructor
@Getter
@Setter
public class GameStarter {

    private HeroBuilder heroBuilder;
    MainHall mainHall;
    double maxHeroHP;
    double maxHeroManaPoint;

    public GameStarter() {
        heroBuilder = new HeroBuilder();

    }


    public void start() {
        System.out.println("Welcome to Arena game");
        Hero hero = heroBuilder.generateHero();
        maxHeroHP = hero.getHealth();
        maxHeroManaPoint = hero.getManaPoint();
        mainHall.intersection(hero);
        Enemy enemy = DarkOrc.buildDefaultOrc();
        while (hero.getHealth() > 0) {
            hero.attack(enemy);
            enemy.attack(hero);
            enemy = generateNewEnemyIfNeeded(enemy);
        }
        System.out.println("Поражение!");
    }

    private Enemy generateNewEnemyIfNeeded(Enemy enemy) {
        if (enemy.getHealth() <= 0) {
            System.out.println("Орк повержен!");
            System.out.println("На арене появляется новый противник!");
            return DarkOrc.buildDefaultOrc();
        } else {
            return enemy;
        }
    }

    @SneakyThrows
    public String readLineFromConsole() {
        String result = null;
        Scanner sc = new Scanner(System.in);
        result = sc.nextLine();
        return result;
    }
}
