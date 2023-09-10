package org.example.characters.hero;

import lombok.Getter;
import lombok.Setter;
import org.example.characters.DamageType;
import org.example.characters.enemy.Enemy;

import java.util.Random;

@Getter
@Setter
public class Warrior extends Hero {

    @Override
    public void attack() {
    }

    @Override
    public void defend(double damage, DamageType type) {
        if (!(isEvaded())) {
        }
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
    private double calculateDamage(double damage, DamageType type){
        switch (type){
            case MAGICAL:{
                break;
            }
            case PHYSICAL:{
                break;
            }
        }
        return damage;
    }
}
