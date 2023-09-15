package org.example;

import lombok.AllArgsConstructor;
import org.example.characters.enemy.impl.DarkOrc;
import org.example.characters.enemy.Enemy;
import org.example.characters.hero.Hero;
import org.example.characters.hero.HeroBuilder;

@AllArgsConstructor
public class GameStarter {

  private HeroBuilder heroBuilder;

  public GameStarter() {
    heroBuilder = new HeroBuilder();
  }

  public void start() {
    System.out.println("Welcome to Arena game");
    Hero hero = heroBuilder.generateHero();
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
      System.out.println("На арене появляется новые противник!");
      return DarkOrc.buildDefaultOrc();
    } else {
      return enemy;
    }
  }
}
