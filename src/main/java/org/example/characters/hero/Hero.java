package org.example.characters.hero;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.characters.Character;
import org.example.characters.DamageType;
import org.example.characters.enemy.Enemy;

@Getter
@Setter
@AllArgsConstructor
public abstract class Hero extends Character {

    public Hero(String name, double health, double manaPoint, double attack, double defence, double magicAttack, double magicDefence, double criticalPowerCoefficient, double evasion, double criticalHitChance) {
        super(name, health, manaPoint, attack, defence, magicAttack, magicDefence, criticalPowerCoefficient, evasion, criticalHitChance);
    }

    public abstract boolean isEvaded();

    protected abstract void attack(Hero hero, Enemy target);

    protected abstract void defend(Hero hero, Enemy target);
}
