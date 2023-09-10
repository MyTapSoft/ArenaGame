package org.example.characters.hero;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.characters.Character;
import org.example.characters.DamageType;
import org.example.characters.enemy.Enemy;

@Getter
@Setter
@AllArgsConstructor
public abstract class Hero extends Character {
    public abstract void attack();
    public abstract void defend(double damage, DamageType type);
    public abstract boolean isEvaded();
}
