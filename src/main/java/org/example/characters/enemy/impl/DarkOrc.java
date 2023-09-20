package org.example.characters.enemy.impl;

import static org.example.characters.actions.DamageType.PHYSICAL;

import java.util.Random;
import lombok.SneakyThrows;
import org.example.characters.actions.Attack;
import org.example.characters.enemy.Enemy;
import org.example.characters.hero.Hero;

public class DarkOrc extends Enemy {

  private double maxChaosChance = 1.15;
  private double minChaosChance = 0.85;

  private final Random random = new Random();

  public DarkOrc(String name, double currentHp, double maxHp, double currentMp, double maxMp,
      double baseAttack, double defence, double magicAttack, double magicDefence,
      double criticalPowerCoefficient, double evasion, double criticalHitChance, double EXPcount,
      double SPcount) {
    super(name, currentHp, maxHp, currentMp, maxMp, baseAttack, defence, magicAttack, magicDefence,
        criticalPowerCoefficient, evasion, criticalHitChance, EXPcount, SPcount);
  }


  public static DarkOrc buildDefaultOrc() {
    return new DarkOrc("Org", 100, 100,10, 10,100, 20, 2, 2, 1, 10, 2,100,20);
  }

  @Override
  public void attack(Hero target) {
    Attack attackDamage = getAttackDamage();
    target.defend(attackDamage);
  }

  @Override
  @SneakyThrows
  public void defend(Attack attack) {
    if (!this.isEvaded()) {
      double receivedDamage = 0;
      switch (attack.getDamageType()) {
        case PHYSICAL -> receivedDamage = attack.getDamage() - this.getDefence();
        case MAGICAL -> receivedDamage = attack.getDamage() - this.getMagicDefence();
      }
      this.currentHp -= receivedDamage;
      System.out.println("Orc received " + receivedDamage + " damage");
      Thread.sleep(100);
    } else {
      System.out.println("Enemy evaded");
    }
  }

  private boolean isEvaded() {
    int rnd = random.nextInt(100);
    if (rnd < this.evasion) {
      System.out.println("Вы увернулись от удара");
      return true;
    }
    return false;
  }

  public Attack getAttackDamage() {
    double max = this.getBaseAttack() * maxChaosChance;
    double min = this.getBaseAttack() * minChaosChance;
    double damage = min + (max - min) * random.nextDouble();
    return new Attack((int) damage, PHYSICAL);
  }
}


