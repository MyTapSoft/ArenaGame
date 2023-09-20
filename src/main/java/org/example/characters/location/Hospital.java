package org.example.characters.location;

import org.example.characters.hero.Hero;

public class Hospital {

  public void fullHeal(Hero hero) {
    hero.fullHeal();
    System.out.println("Персонаж полность здоров");
  }

  public void fullHealHP(Hero hero) {
    hero.setCurrentHp(hero.getMaxHp());
  }

  public void fullRechargeMP(Hero hero) {
    hero.setCurrentMp(hero.getMaxMp());
  }
}
