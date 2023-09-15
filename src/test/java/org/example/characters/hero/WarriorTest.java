package org.example.characters.hero;

import org.example.characters.hero.impl.Warrior;

class WarriorTest {
  Warrior warrior = new Warrior("Grin", 100, 100, 100,10,10,25,2,10,15);

  @org.junit.jupiter.api.Test
  void getAttackDamage() {
    warrior.getAttackDamage();
  }
}