package org.example.characters.location;

import java.util.List;
import org.example.GameStarter;
import org.example.characters.enemy.Enemy;
import org.example.characters.hero.Hero;

import java.util.Scanner;

public class Arena extends Location{
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

    @Override
    public String getLocationName() {
        return "Arena";
    }

    @Override
    public String getLocationId() {
        return "2";
    }

    @Override
    public List<String> getPaths() {
        return List.of("1");
    }
}
