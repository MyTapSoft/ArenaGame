package org.example.characters.hero.impl;

import static org.example.characters.actions.DamageType.PHYSICAL;

import java.util.Random;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.example.characters.actions.Attack;
import org.example.characters.enemy.Enemy;
import org.example.characters.hero.Hero;
import org.example.characters.location.AbstractLocation;
import org.example.characters.location.Location;

@Getter
@Setter
public class Warrior extends Hero {

    private static double maxChaosChance = 1.15;
    private static double minChaosChance = 0.85;
    private Random random = new Random();

    public Warrior(String name, double currentHp, double maxHp, double currentMp, double maxMp,
                   double baseAttack, double defence, double magicAttack, double magicDefence,
                   double criticalPowerCoefficient, double evasion, double criticalHitChance, double EXPcount,
                   double SPcount, AbstractLocation currentLocation) {
        super(name, currentHp, maxHp, currentMp, maxMp, baseAttack, defence, magicAttack, magicDefence,
                criticalPowerCoefficient, evasion, criticalHitChance, EXPcount, SPcount, currentLocation);
    }


    public static Warrior buildDefaultWarrior() {
        return new Warrior("Grin", 300, 300, 100, 100, 50, 80,
                10, 25, 2, 10, 15, 0, 0, Location.getLocationById("1"));
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
            double receivedDamage = switch (attack.getDamageType()) {
                case PHYSICAL -> attack.getDamage() - this.getDefence();
                case MAGICAL -> attack.getDamage() - this.getMagicDefence();
            };
            this.currentHp -= receivedDamage;
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
        return new Attack((int) damage, PHYSICAL);
    }

}
