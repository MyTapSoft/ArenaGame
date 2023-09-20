package org.example.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class UserInputHandler {
private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
  private UserInputHandler() {
  }

  public static String getUserInput() {
    String userInput = null;
    try {
      userInput = bufferedReader.readLine();
    } catch (IOException e) {
      System.out.println("Can't read user input");
    }
    return userInput;
  }
}
