package pl.zamaskowany.ui;

import java.util.Scanner;

public class ConsoleUserInterface {

    // Scanner to wbudowane w Javę narzędzie do czytania wejścia (np. z klawiatury)
    private final Scanner scanner;

    public ConsoleUserInterface() {
        // System.in oznacza standardowe wejście (terminal)
        this.scanner = new Scanner(System.in);
    }

    public void printWelcomeScreen() {
        System.out.println("===============================");
        System.out.println("      ZAMASKOWANY GAME         ");
        System.out.println("===============================");
    }

    public String askForPlayerName() {
        System.out.print("Wędrowcze, jak się zowiesz? ");
        // Metoda nextLine() czeka, aż gracz coś wpisze i wciśnie Enter
        return scanner.nextLine();
    }
}