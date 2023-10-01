package org.example.characters.skills;

import org.example.characters.Character;

public class PowerShield extends Skill {

  private final int defaultCooldown = 3;

  public PowerShield() {
    this.name = "Power Shield";
    this.cooldown = 0;
  }


  @Override
  public void use(Character character) {
    if (cooldown == 0) {
      character.setDefence(character.getDefence() * 2.5);
      cooldown = defaultCooldown;
      System.out.println("Защита увеличена!");
    }else {
      System.out.println("Скилл еще не восстановился. Осталось холов: " + cooldown);
    }
  }
}
