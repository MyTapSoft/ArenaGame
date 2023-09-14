package org.example;

import org.example.characters.enemy.DarkOrc;
import org.example.characters.enemy.Enemy;
import org.example.characters.hero.Hero;
import org.example.characters.hero.Warrior;

public class Main {

    public static void main(String[] args) {
        Hero hero = Warrior.buildDefaultWarrior();
        Enemy enemy = DarkOrc.buildDefaultOrc();
        double currentHP;
        while (true) {
            hero.attack(enemy);
            enemy.attack(hero);
            if (enemy.getHealth() < 0 || enemy.getHealth() == 0) {
                currentHP = hero.getHealth();
                if (currentHP > 0) {
                    System.out.println("!!!НОВЫЙ ПРОТИВНИК!!!");
                    hero.attack(DarkOrc.buildDefaultOrc());
                    System.out.println("!!!ПОБЕДА!!!");
                    System.out.println("!!!ЕЩЕ ОДИН ОРК ПОВЕРЖЕН!!!");
                }
                if (currentHP < 0 || currentHP == 0) {
                    System.out.println("!!!ГЕРОЙ ПОВЕРЖЕН!!!");
                    break;
                }
            }

        }
    }
}
