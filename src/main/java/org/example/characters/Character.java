package org.example.characters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Character {
    public String name;
    public double currentHp;
    public double maxHp;
    public double currentMp;
    public double maxMp;
    public double baseAttack;
    public double defence;
    public double magicAttack;
    public double magicDefence;
    public double criticalPowerCoefficient;
    public double evasion;
    public double criticalHitChance;
    public double EXPcount;
    public double SPcount;
}
