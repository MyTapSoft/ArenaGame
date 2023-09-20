package org.example.characters.enemy;

import lombok.Getter;
import lombok.Setter;
import org.example.characters.Character;
import org.example.characters.actions.Attack;
import org.example.characters.hero.Hero;

@Getter
@Setter
public abstract class Enemy extends Character {


  public Enemy(String name, double currentHp, double maxHp, double currentMp, double maxMp,
      double baseAttack, double defence, double magicAttack, double magicDefence,
      double criticalPowerCoefficient, double evasion, double criticalHitChance, double EXPcount,
      double SPcount) {
    super(name, currentHp, maxHp, currentMp, maxMp, baseAttack, defence, magicAttack, magicDefence,
        criticalPowerCoefficient, evasion, criticalHitChance, EXPcount, SPcount);
  }

  public abstract void attack(Hero target);

  public abstract void defend(Attack attack);
}
