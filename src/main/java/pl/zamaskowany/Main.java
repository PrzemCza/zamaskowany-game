package pl.zamaskowany;

import pl.zamaskowany.model.Player;
import pl.zamaskowany.model.Enemy;
import pl.zamaskowany.engine.CombatEngine;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== ZAMASKOWANY GAME ===");
        System.out.println("Witaj w mrocznym świecie...\n");

        //Tworzymy gracza oraz potwora (Powołujemy obiekty)
        Player hero = new Player("Wojtek", 200, 25);
        Enemy monster = new Enemy("Ponury Goblin", 60, 12);

        //Tworzymy nasz serwis walki
        CombatEngine engine = new CombatEngine();

        //Rozpoczynamy starcie przekazując obiekty do silnika
        engine.fight(hero, monster);


    }
}