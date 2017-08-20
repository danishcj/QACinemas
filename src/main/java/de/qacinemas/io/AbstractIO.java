package de.qacinemas.io;

import java.util.Scanner;

public class AbstractIO {
    protected static final Scanner userInput = new Scanner(System.in);
    protected void cls() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
