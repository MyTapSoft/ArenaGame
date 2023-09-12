package org.example.characters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Character {
    public String name;
    public double health;
    public double manaPoint;
    public double baseAttack;
    public double defence;
    public double magicAttack;
    public double magicDefence;
    public double criticalPowerCoefficient;
    public double evasion;
    public double criticalHitChance;

}
