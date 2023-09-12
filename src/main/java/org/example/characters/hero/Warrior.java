package org.example.characters.hero;

import static org.example.characters.actions.DamageType.PHYSICAL;

import java.util.Random;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.example.characters.actions.Attack;
import org.example.characters.actions.DamageType;
import org.example.characters.enemy.Enemy;

@Getter
@Setter
public class Warrior extends Hero {

  private static double chaosChance = 15.0;
  private Random random = new Random();

  public Warrior(String name, double health, double manaPoint, double attack, double defence,
      double magicAttack,
      double magicDefence, double criticalPowerCoefficient, double evasion,
      double criticalHitChance) {
    super(name, health, manaPoint, attack, defence, magicAttack, magicDefence,
        criticalPowerCoefficient, evasion, criticalHitChance);
  }

  public static Warrior buildDefaultWarrior() {
    return new Warrior("Grin", 100, 100, 1000, 10, 10, 25, 2, 10, 15);
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
    Random random = new Random();
    int rnd = random.nextInt(100);
    if (rnd < this.evasion) {
      System.out.println("Вы увернулись от удара");
      return true;
    }
    return false;
  }


  public Attack getAttackDamage() {
    return new Attack((int)this.getBaseAttack(), PHYSICAL);
  }

  private double calculateDefend(Hero hero, DamageType type, Enemy enemy) {
    double damage = 0;
    switch (type) {
      case MAGICAL: {

      }
      case PHYSICAL: {

      }
    }
    return damage;
  }
}
