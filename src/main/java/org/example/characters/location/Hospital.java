package org.example.characters.location;

import org.example.GameStarter;
import org.example.characters.hero.Hero;
import org.example.characters.hero.HeroBuilder;
import org.example.characters.hero.impl.Warrior;

public class Hospital {
    GameStarter gs = new GameStarter();
    public void fullHeal(Hero hero) {
        double maxHP = gs.getMaxHeroHP();
        double maxMP = gs.getMaxHeroManaPoint();
        hero.setHealth(maxHP);
        hero.setManaPoint(maxMP);
    }

    public void fullHealHP(Hero hero) {
        double maxHP = gs.getMaxHeroHP();
        hero.setHealth(maxHP);
    }

    public void fullRechargeMP(Hero hero) {
        double maxMP = gs.getMaxHeroManaPoint();
        hero.setManaPoint(maxMP);
    }
}
