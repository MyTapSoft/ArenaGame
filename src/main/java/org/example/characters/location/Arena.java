package org.example.characters.location;

import org.example.GameStarter;
import org.example.characters.enemy.Enemy;
import org.example.characters.hero.Hero;

import java.util.Scanner;

public class Arena {
    public void acquireExperience(Hero hero, Enemy enemy){
        double exp = enemy.getEXPcount();
        double heroExp = hero.getEXPcount();
        hero.setEXPcount(exp+heroExp);
    }
    public void acquireSkillPoint(Hero hero, Enemy enemy){
        double exp = enemy.getEXPcount();
        double heroExp = hero.getEXPcount();
        hero.setEXPcount(exp+heroExp);
    }
    public void switchEnemy(){

    }

}
