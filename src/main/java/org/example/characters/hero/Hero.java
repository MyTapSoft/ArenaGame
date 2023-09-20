package org.example.characters.hero;

import lombok.Getter;
import lombok.Setter;
import org.example.characters.Character;
import org.example.characters.actions.Attack;
import org.example.characters.enemy.Enemy;
import org.example.characters.location.Location;

@Getter
@Setter
public abstract class Hero extends Character {

  private Location currentLocation;

  public Hero(String name, double currentHp, double maxHp, double currentMp, double maxMp,
      double baseAttack, double defence, double magicAttack, double magicDefence,
      double criticalPowerCoefficient, double evasion, double criticalHitChance, double EXPcount,
      double SPcount, Location currentLocation) {
    super(name, currentHp, maxHp, currentMp, maxMp, baseAttack, defence, magicAttack, magicDefence,
        criticalPowerCoefficient, evasion, criticalHitChance, EXPcount, SPcount);
    this.currentLocation = currentLocation;
  }

  public abstract boolean isEvaded();

  public abstract void attack(Enemy target);

  public abstract void defend(Attack attack);

  public void fullHeal() {
    this.currentHp = this.maxHp;
    this.currentMp = this.maxMp;
  }
}




