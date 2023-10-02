package org.example.characters.hero;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.example.characters.Character;
import org.example.characters.actions.Attack;
import org.example.characters.enemy.Enemy;
import org.example.characters.location.AbstractLocation;
import org.example.characters.skills.PowerShield;
import org.example.characters.skills.PowerStrike;

@Getter
@Setter
public abstract class Hero extends Character {

  private AbstractLocation currentLocation;

  public Hero(String name, double currentHp, double maxHp, double currentMp, double maxMp,
      double baseAttack, double defence, double magicAttack, double magicDefence,
      double criticalPowerCoefficient, double evasion, double criticalHitChance, double EXPcount,
      double SPcount, AbstractLocation currentLocation) {
    super(name, currentHp, maxHp, currentMp, maxMp, baseAttack, defence, magicAttack, magicDefence,
        criticalPowerCoefficient, evasion, criticalHitChance, EXPcount, SPcount, List.of(new PowerShield(), new PowerStrike()));
    this.currentLocation = currentLocation;
  }

  public abstract boolean isEvaded();

  public abstract void attack(Enemy target);

  public abstract void defend(Attack attack);

}




