package org.example.characters.skills;

import lombok.Data;
import org.example.characters.Character;
@Data
public abstract class Skill {

  protected String name;
  protected int cooldown;

  protected int totalDuration;
  protected int currentDuration;

  public abstract void use(Character character);

  public void decreaseCooldown() {
    if (cooldown > 0) {
      cooldown -= 1;
    }
  }
}
