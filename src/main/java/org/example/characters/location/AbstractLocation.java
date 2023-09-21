package org.example.characters.location;

import java.util.List;
import org.example.characters.hero.Hero;

public abstract class AbstractLocation {

  public abstract String getLocationName();

  public abstract String getLocationId();

  public abstract List<AbstractLocation> getPaths();

  public abstract void interact(Hero hero);
}
