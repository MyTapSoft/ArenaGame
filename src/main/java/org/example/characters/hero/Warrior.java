package org.example.characters.hero;

import static org.example.characters.actions.DamageType.PHYSICAL;

import java.util.Random;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.example.characters.actions.Attack;
import org.example.characters.enemy.Enemy;

@Getter
@Setter
public class Warrior extends Hero {

  private static double maxChaosChance = 1.15;
  private static double minChaosChance = 0.85;
  private Random random = new Random();

  public Warrior(String name, double health, double manaPoint, double attack, double defence,
      double magicAttack,
      double magicDefence, double criticalPowerCoefficient, double evasion,
      double criticalHitChance) {
    super(name, health, manaPoint, attack, defence, magicAttack, magicDefence,
        criticalPowerCoefficient, evasion, criticalHitChance);
  }

  public static Warrior buildDefaultWarrior() {
    return new Warrior("Grin", 300, 100, 50, 80, 10, 25, 2, 10, 15);
  }


  @Override
  public void attack(Enemy target) {
    Attack attackDamage = getAttackDamage();
    target.defend(attackDamage);
  }

  @Override
  @SneakyThrows
  public void defend(Attack attack) {
    if (!this.isEvaded()) {
      double receivedDamage = 0;
      switch (attack.getDamageType()) {
        case PHYSICAL:
          receivedDamage = attack.getDamage() - this.getDefence();
          break;
        case MAGICAL:
          receivedDamage = attack.getDamage() - this.getMagicDefence();
          break;
      }
      this.health -= receivedDamage;
      System.out.println("Hero received " + receivedDamage + " damage");
      Thread.sleep(100);
    }
  }

  @Override
  public boolean isEvaded() {
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
    return new Attack((int)damage, PHYSICAL);
  }
}
