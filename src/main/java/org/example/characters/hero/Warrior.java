package org.example.characters.hero;

import lombok.Getter;
import lombok.Setter;
import org.example.characters.DamageType;
import org.example.characters.enemy.Enemy;

import java.util.Random;

@Getter
@Setter
public class Warrior extends Hero {
    public Warrior(String name, double health, double manaPoint, double attack, double defence, double magicAttack,
                   double magicDefence, double criticalPowerCoefficient, double evasion, double criticalHitChance) {
        super(name, health, manaPoint, attack, defence, magicAttack, magicDefence, criticalPowerCoefficient, evasion, criticalHitChance);
    }

    Warrior warrior = new Warrior("Warrior", 1000, 200, 150, 80,
            50, 100, 3, 15, 30);

    @Override
    protected void attack(Hero hero, Enemy target) {
        calculateDamage(hero,DamageType.MAGICAL,target);
        calculateDamage(hero,DamageType.PHYSICAL,target);
    }

    @Override
    protected void defend(Hero hero, Enemy target) {
        calculateDefend(hero,DamageType.MAGICAL,target);
        calculateDefend(hero,DamageType.PHYSICAL,target);


    }


    @Override
    public boolean isEvaded() {
        Random random = new Random();
        int rnd = random.nextInt(100);
        if (rnd < this.evasion) {
            System.out.println("Вы увернулись от удара");
            return true;
        }
        return false;
    }


    private double calculateDamage(Hero hero, DamageType type, Enemy enemy) {
        double damage = 0;
        switch (type) {
            case MAGICAL: {
                if (!(isEvaded())) {
                    damage = hero.magicAttack - enemy.magicDefence;
                    enemy.health = enemy.health - damage;
                    System.out.println("Вы нанесли " + damage + " урона");
                    break;
                }
            }
            case PHYSICAL: {
                if (!(isEvaded())) {
                    damage = hero.attack - enemy.defence;
                    enemy.health = enemy.health - damage;
                    System.out.println("Вы нанесли " + damage + " урона");
                    break;
                }
            }
        }
        return damage;
    }
    private double calculateDefend(Hero hero, DamageType type, Enemy enemy){
        double damage = 0;
        switch (type){
            case MAGICAL:{

            }
            case PHYSICAL:{

            }
        }
        return damage;
    }
}
