package org.example.characters.enemy;

import static org.example.characters.actions.DamageType.PHYSICAL;

import java.util.Random;
import lombok.SneakyThrows;
import org.example.characters.actions.Attack;
import org.example.characters.hero.Hero;

public class DarkOrc extends Enemy {

  private double maxChaosChance = 1.15;
  private double minChaosChance = 0.85;

  private final Random random = new Random();

  public DarkOrc(String name, double health, double manaPoint, double attack, double defence,
      double magicAttack, double magicDefence, double criticalPowerCoefficient, double evasion,
      double criticalHitChance) {
    super(name, health, manaPoint, attack, defence, magicAttack, magicDefence,
        criticalPowerCoefficient, evasion, criticalHitChance);
  }

  public static DarkOrc buildDefaultOrc() {
    return new DarkOrc("Org", 100, 10, 100, 20, 2, 2, 1, 10, 2);
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
        case PHYSICAL -> {
          receivedDamage = attack.getDamage() - this.getDefence();
        }
        case MAGICAL -> {
          receivedDamage = attack.getDamage() - this.getMagicDefence();
        }
      }
      this.health -= receivedDamage;
      System.out.println("Orc received " + receivedDamage + " damage");
      Thread.sleep(100);
    } else {
      System.out.println("Enemy evaded");
    }
  }

  private boolean isEvaded() {
    return new Random().nextBoolean();
  }

  public Attack getAttackDamage() {
    double max = this.getBaseAttack() * maxChaosChance;
    double min = this.getBaseAttack() * minChaosChance;
    double damage = min + (max - min) * random.nextDouble();
    return new Attack((int) damage, PHYSICAL);
  }
}


