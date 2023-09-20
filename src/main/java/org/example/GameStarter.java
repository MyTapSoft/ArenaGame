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
import org.example.characters.location.DefaultLocation;
import org.example.characters.location.Hospital;

@AllArgsConstructor
@Getter
@Setter
public class GameStarter {

  private HeroBuilder heroBuilder;
  private DefaultLocation mainHall;
  private Hospital hospital;
  double maxHeroHP;
  double maxHeroManaPoint;

  public GameStarter() {
    hospital = new Hospital();
    heroBuilder = new HeroBuilder();
    mainHall = new DefaultLocation(hospital);
  }


  public void start() {
    System.out.println("Welcome to Arena game");
    Hero hero = heroBuilder.generateHero();
    maxHeroHP = hero.getCurrentHp();
    maxHeroManaPoint = hero.getCurrentMp();
    mainHall.intersection(hero);
    Enemy enemy = DarkOrc.buildDefaultOrc();
    while (hero.getCurrentHp() > 0) {
      hero.attack(enemy);
      enemy.attack(hero);
      enemy = generateNewEnemyIfNeeded(enemy);
    }
    System.out.println("Поражение!");
  }

  private Enemy generateNewEnemyIfNeeded(Enemy enemy) {
    if (enemy.getCurrentHp() <= 0) {
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
