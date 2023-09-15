package org.example.characters.actions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Attack {

  private int damage;
  private DamageType damageType;


}
