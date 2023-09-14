package org.example;

import org.example.characters.enemy.DarkOrc;
import org.example.characters.enemy.Enemy;
import org.example.characters.hero.Hero;
import org.example.characters.hero.Warrior;

public class Main {

    public static void main(String[] args) {
        Hero hero = Warrior.buildDefaultWarrior();
        Enemy enemy = DarkOrc.buildDefaultOrc();

        while (hero.getHealth() > 0 && enemy.getHealth() > 0) {
            hero.attack(enemy);
            enemy.attack(hero);
            if (hero.getHealth() == 0 || hero.getHealth() < 0) {
                System.out.println("!!!Герой проиграл!!!");
            } else if (enemy.getHealth() == 0 || enemy.getHealth() < 0) {
                System.out.println("!!!Герой выиграл!!!");
            }
        }
    }
}
