package org.example.characters.location;

import java.util.ArrayList;
import java.util.List;
import org.example.characters.enemy.Enemy;
import org.example.characters.hero.Hero;
import org.example.ui.UserInputHandler;

public class Arena extends AbstractLocation {

    public void acquireExperience(Hero hero, Enemy enemy){
        double exp = enemy.getEXPcount();
        double heroExp = hero.getEXPcount();
        hero.setEXPcount(exp+heroExp);
    }
    public void acquireSkillPoint(Hero hero, Enemy enemy){
        double exp = enemy.getEXPcount();
        double heroExp = hero.getEXPcount();
        hero.setEXPcount(exp+heroExp);
    }
    public void switchEnemy(){

    }

    public void startFight(){
        System.out.println("Fight done");
    }

    @Override
    public String getLocationName() {
        return "Arena";
    }

    @Override
    public String getLocationId() {
        return "2";
    }

    @Override
    public List<AbstractLocation> getPaths() {
        List<AbstractLocation> possibleMoves = new ArrayList<>();
        for (AbstractLocation location : Location.getAllLocations()) {
            if (location.getLocationId().equals("1")) {
                possibleMoves.add(location);
            }
        }
        return possibleMoves;
    }

    @Override
    public void interact(Hero hero) {
        boolean isLocationChanged = false;
        while (!isLocationChanged) {
            System.out.println("Вы в госпитале и бла бла бла");
            System.out.println("Что делаем?");
            System.out.println("1 - Деремся");
            System.out.println("2 - Уходим");
            String answer = UserInputHandler.getUserInput();
            if (answer.equalsIgnoreCase("1")) {
                startFight();
            } else if (answer.equalsIgnoreCase("2")) {
                System.out.println("Куда?");
                for (AbstractLocation path : getPaths()) {
                    System.out.println(path.getLocationId() + ": " + path.getLocationName());
                }
                String answer2 = UserInputHandler.getUserInput();
                for (AbstractLocation path : getPaths()) {
                    if (answer2.equals(path.getLocationId())){
                        hero.setCurrentLocation(path);
                        isLocationChanged = true;
                        break;
                    }
                }
                System.out.println("Unknown location...");
            }
        }
        hero.getCurrentLocation().interact(hero);
    }
}
