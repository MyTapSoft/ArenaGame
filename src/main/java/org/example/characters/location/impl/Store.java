package org.example.characters.location.impl;

import org.example.characters.hero.Hero;
import org.example.characters.location.AbstractLocation;
import org.example.characters.location.Location;
import org.example.ui.DialoguesAndMessages;
import org.example.ui.UserInputHandler;

import java.util.ArrayList;
import java.util.List;

public class Store extends AbstractLocation {
    DialoguesAndMessages diam = new DialoguesAndMessages();

    @Override
    public String getLocationName() {
        return "Магазин.";
    }

    @Override
    public String getLocationId() {
        return "4";
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
        System.out.println("Добро пожаловать в магазин. Здесь вы можете приобрести товары первой необходимости.");
        diam.storeFirst();
        while (!isLocationChanged) {

            String answer = UserInputHandler.getUserInput();
            if (answer.equalsIgnoreCase("1")) {

            } else if (answer.equalsIgnoreCase("2")) {

            } else if (answer.equalsIgnoreCase("3")) {

            } else if (answer.equalsIgnoreCase("4")) {
                System.out.println("Куда пойдем?");
                for (AbstractLocation path : getPaths()) {
                    System.out.println(path.getLocationId() + ": " + path.getLocationName());
                }
                String answer2 = UserInputHandler.getUserInput();
                for (AbstractLocation path : getPaths()) {
                    if (answer2.equals(path.getLocationId())) {
                        hero.setCurrentLocation(path);
                        isLocationChanged = true;
                        break;
                    }
                }
            }
        }
    }
}
