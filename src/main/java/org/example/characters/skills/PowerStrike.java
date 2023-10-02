package org.example.characters.skills;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.characters.Character;
import org.example.characters.enemy.Enemy;
import org.example.characters.hero.Hero;

@Data
public class PowerStrike extends Skill {
    private final int defaultCooldown = 3;
    private double damage;


    public PowerStrike() {
        this.name = "Power Strike";
        this.cooldown = 0;
        this.damage = 0;
    }

    public void use(Character character, Enemy target) {
        if (cooldown == 0) {
            damage = (character.baseAttack * 1.5) - target.getDefence();
            if (damage > 0) {
                target.currentHp -= damage;
                if (target.currentHp < 0) {
                    target.currentHp = 0;
                }
            }
            cooldown = defaultCooldown;
            System.out.println("Power Strike наносит " + damage + " урона!");
        } else System.out.println("Скилл еще не восстановился. Осталось ходов: " + cooldown);
    }

    @Override
    public void use(Character character) {

    }
}

