package pl.zamaskowany;

import pl.zamaskowany.model.Player;
import pl.zamaskowany.model.Enemy;
import pl.zamaskowany.engine.CombatEngine;
import pl.zamaskowany.ui.ConsoleUserInterface;

public class Main {
    public static void main(String[] args) {
        // 1. Powołujemy do życia nasz interfejs użytkownika
        ConsoleUserInterface ui = new ConsoleUserInterface();

        // 2. Odpalamy ekran powitalny i prosimy o imię
        ui.printWelcomeScreen();
        String playerName = ui.askForPlayerName(); // Gra w tym miejscu się zatrzyma i poczeka na Twój wpis!

        //Tworzymy gracza oraz potwora (Powołujemy obiekty)
        Player hero = new Player(playerName, 200, 25);
        Enemy monster = new Enemy("Ponury Goblin", 60, 12);

        //Tworzymy nasz serwis walki

        CombatEngine engine = new CombatEngine();
        System.out.println("\n[System]: Generowanie świata...\n");
        //Rozpoczynamy starcie przekazując obiekty do silnika
        engine.fight(hero, monster);


    }
}