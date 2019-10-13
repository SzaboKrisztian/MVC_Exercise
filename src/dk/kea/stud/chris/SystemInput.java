package dk.kea.stud.chris;

import java.util.Scanner;

public class SystemInput {
  private static SystemInput instance;
  private Scanner scn;

  private SystemInput() {
    scn = new Scanner(System.in);
  }

  public static SystemInput getInstance() {
    if (instance == null) {
      instance = new SystemInput();
    }

    return instance;
  }

  public String getLine() {
    return scn.nextLine();
  }

  public int getInt() {
    int result = scn.nextInt();
    scn.nextLine();
    return result;
  }
}