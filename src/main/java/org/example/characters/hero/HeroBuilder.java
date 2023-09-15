package org.example.characters.hero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import lombok.Data;
import org.example.characters.hero.impl.Warrior;

@Data
public class HeroBuilder {

  public Hero generateHero() {
    String characterName = null;
    System.out.print("Enter character name: ");
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      while (characterName == null) {
        characterName = reader.readLine();
      }
    } catch (IOException e) {
      System.out.println("Unknown error");
      throw new RuntimeException(e);
    }
    Hero hero = Warrior.buildDefaultWarrior();
    hero.setName(characterName);
    return hero;
  }
}
