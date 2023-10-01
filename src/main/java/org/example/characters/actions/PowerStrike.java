package org.example.characters.actions;

import lombok.Getter;
import lombok.Setter;
import org.example.characters.enemy.Enemy;
import org.example.characters.hero.Hero;

@Getter
@Setter
public class PowerStrike implements Skill {
    private String name;
    private int cooldown;
    private double damage;

    public PowerStrike(String name, int cooldown, double damage) {
        this.name = name;
        this.cooldown = cooldown;
        this.damage = damage;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCooldown() {
        return cooldown;
    }

    @Override
    public void activate(Hero source, Enemy target) {
        if (cooldown <= 0) {
            double actualDamage = damage - target.getDefence();
            if (actualDamage > 0) {
                target.currentHp -= damage;
                if (target.currentHp < 0) {
                    target.currentHp = 0;
                }
                cooldown = getCooldown();
            }
        }
    }
    public static PowerStrike generatePowerStrike(){
        return new PowerStrike("Power_Strike", 3, 250);
    }
}
