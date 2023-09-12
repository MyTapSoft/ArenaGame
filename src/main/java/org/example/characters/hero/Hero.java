package org.example.characters.hero;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.characters.Character;
import org.example.characters.actions.Attack;
import org.example.characters.enemy.Enemy;

@Getter
@Setter
public abstract class Hero extends Character {


    public Hero(String name, double health, double manaPoint, double baseAttack, double defence,
        double magicAttack, double magicDefence, double criticalPowerCoefficient, double evasion,
        double criticalHitChance) {
        super(name, health, manaPoint, baseAttack, defence, magicAttack, magicDefence,
            criticalPowerCoefficient, evasion, criticalHitChance);
    }

    public abstract boolean isEvaded();

    public abstract void attack(Enemy target);

    public abstract void defend(Attack attack);
}
