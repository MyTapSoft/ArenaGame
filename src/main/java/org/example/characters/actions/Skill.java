package org.example.characters.actions;

import lombok.Getter;
import lombok.Setter;
import org.example.characters.enemy.Enemy;
import org.example.characters.hero.Hero;

public interface Skill {
    String getName();
    int getCooldown();
    void activate(Hero source, Enemy target);
}
