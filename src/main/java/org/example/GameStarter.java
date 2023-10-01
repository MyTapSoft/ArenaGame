package org.example;

import java.util.Scanner;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.example.characters.enemy.Enemy;
import org.example.characters.enemy.impl.DarkOrc;
import org.example.characters.hero.Hero;
import org.example.characters.hero.HeroBuilder;

@AllArgsConstructor
@Getter
@Setter
public class GameStarter {

  private HeroBuilder heroBuilder;
  double maxHeroHP;
  double maxHeroManaPoint;

  public GameStarter() {
    heroBuilder = new HeroBuilder();
  }


  public void start() {
    System.out.println("Welcome to Arena game");
    Hero hero = heroBuilder.generateHero();
    while (hero.getCurrentHp() > 0) {
      hero.getCurrentLocation().interact(hero);
    }
    System.out.println("Finito!");
  }

  public Enemy generateNewEnemyIfNeeded(Enemy enemy) {
    if (enemy.getCurrentHp() <= 0) {
      System.out.println("Орк повержен!");
      System.out.println("На арене появляется новый противник!");
      return DarkOrc.buildDefaultOrc();
    } else {
      return enemy;
    }
  }
}
