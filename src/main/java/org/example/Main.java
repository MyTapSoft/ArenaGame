package org.example;

import org.example.characters.location.MainHall;

public class Main {

  public static void main(String[] args) {
    GameStarter gameStarter = new GameStarter();
    gameStarter.mainHall = new MainHall();
    gameStarter.start();
    }
}
