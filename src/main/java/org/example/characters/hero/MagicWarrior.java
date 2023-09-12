package org.example.characters.hero;

import org.example.characters.enemy.Enemy;

public class MagicWarrior extends Hero{
    public MagicWarrior(String name, double health, double manaPoint, double attack, double defence,
                        double magicAttack, double magicDefence, double criticalPowerCoefficient, double evasion, double criticalHitChance) {
        super(name, health, manaPoint, attack, defence, magicAttack, magicDefence, criticalPowerCoefficient, evasion, criticalHitChance);
    }

    @Override
    public boolean isEvaded() {
        return false;
    }

    @Override
    protected void attack(Hero hero, Enemy target) {

    }

    @Override
    protected void defend(Hero hero, Enemy target) {

    }


}
