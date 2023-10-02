package org.example.characters.skills;

import lombok.Data;
import org.example.characters.Character;
import org.example.characters.enemy.Enemy;

@Data
public abstract class Skill {

  protected String name;
  protected int cooldown;

  protected int totalDuration;
  protected int currentDuration;

  public abstract void use(Character character);
  public abstract void use(Character character, Enemy enemy);

  public void decreaseCooldown() {
    if (cooldown > 0) {
      cooldown -= 1;
    }
  }
}
