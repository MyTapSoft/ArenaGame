package org.example.characters.hero;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {
  Warrior warrior = new Warrior("Grin", 100, 100, 100,10,10,25,2,10,15);

  @org.junit.jupiter.api.Test
  void getAttackDamage() {
    warrior.getAttackDamage();
  }
}