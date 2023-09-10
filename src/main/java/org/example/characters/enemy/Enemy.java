package org.example.characters.enemy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.characters.Character;
import org.example.characters.hero.Hero;

@Getter
@Setter
@AllArgsConstructor
public abstract class Enemy extends Character {
    public abstract void attack(Hero target);
    public abstract void defend(Hero target);
}
