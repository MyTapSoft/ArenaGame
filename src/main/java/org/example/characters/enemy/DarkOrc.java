package org.example.characters.enemy;

import static org.example.characters.actions.DamageType.PHYSICAL;

import java.util.Random;

import lombok.SneakyThrows;
import org.example.characters.actions.Attack;
import org.example.characters.hero.Hero;

public class DarkOrc extends Enemy {

    public DarkOrc(String name, double health, double manaPoint, double attack, double defence,
                   double magicAttack, double magicDefence, double criticalPowerCoefficient, double evasion,
                   double criticalHitChance) {
        super(name, health, manaPoint, attack, defence, magicAttack, magicDefence,
                criticalPowerCoefficient, evasion, criticalHitChance);
    }

    public static DarkOrc buildDefaultOrc() {
        return new DarkOrc("Org", 600, 10, 100, 20, 2, 2, 1, 10, 2);
    }

    @Override
    public void attack(Hero target) {
        Attack attackDamage = getAttackDamage();
        target.defend(attackDamage);
    }

    @Override
    @SneakyThrows
    public void defend(Attack attack) {
        if (!this.isEvaded()) {
            double receivedDamage = 0;
            switch (attack.getDamageType()) {
                case PHYSICAL -> {
                    receivedDamage = attack.getDamage() - this.getDefence();
                    randomDamage(receivedDamage);
                }
                case MAGICAL -> {
                    receivedDamage = attack.getDamage() - this.getMagicDefence();
                    randomDamage(receivedDamage);
                }
            }
            this.health -= receivedDamage;
            System.out.println("Orc received " + receivedDamage + " damage");
            Thread.sleep(100);
        } else {
            System.out.println("Enemy evaded");
        }
    }

    private boolean isEvaded() {
        return new Random().nextBoolean();
    }

    public Attack getAttackDamage() {
        return new Attack((int) this.baseAttack, PHYSICAL);
    }

    public double randomDamage(double incomingDamage) {
        double finalResult;
        Random random = new Random();
        boolean increaseDamage = random.nextBoolean();
        double changePercentage = 0.2;

        if (increaseDamage) {
            incomingDamage += incomingDamage * changePercentage;
            finalResult = incomingDamage;
        } else {
            incomingDamage -= incomingDamage * changePercentage;
            finalResult = incomingDamage;
        }

        return finalResult;
    }
}


