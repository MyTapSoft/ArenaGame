package org.example.characters.hero;

import lombok.Data;
import org.example.characters.hero.impl.Warrior;
import org.example.ui.UserInputHandler;

@Data
public class HeroBuilder {

  public Hero generateHero() {
    System.out.print("Enter character name: ");
    String characterName = UserInputHandler.getUserInput();
    Hero hero = Warrior.buildDefaultWarrior();
    hero.setName(characterName);
    return hero;
  }
}
