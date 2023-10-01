package org.example.characters.hero;

import org.example.characters.hero.impl.Warrior;
import org.example.characters.location.Location;

class WarriorTest {
  Warrior warrior = new Warrior("Grin", 100, 100, 100,10,10,25,
          2,10,15,0,0,0,0, Location.getLocationById("1"));

  @org.junit.jupiter.api.Test
  void getAttackDamage() {
    warrior.getAttackDamage();
  }
}