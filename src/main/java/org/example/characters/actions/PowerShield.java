package org.example.characters.actions;

import org.example.characters.enemy.Enemy;
import org.example.characters.hero.Hero;

public class PowerShield implements Skill {
    private String name;
    private int cooldown;


    public PowerShield(String name, int cooldown) {
        this.name = name;
        this.cooldown = cooldown;

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
            source.defence = source.defence * 2.5;
            cooldown = getCooldown();
        }
    }
    public static PowerShield generatePowerShield(){
        return new PowerShield("Power_Shield",3);
    }
}
