package pl.zamaskowany.engine;

import pl.zamaskowany.model.Enemy;
import pl.zamaskowany.model.Player;

public class CombatEngine {

    public void fight(Player player, Enemy enemy) {
        System.out.println("⚔️ Rozpoczyna się walka: " + player.getName() + " vs " + enemy.getName() + "!");

        // Pętla walki: trwa tak długo, jak OBAJ wojownicy żyją
        while (player.isAlive() && enemy.isAlive()) {

            // 1. Tura Gracza
            System.out.println("➡️ " + player.getName() + " atakuje za " + player.getAttackPower() + " obrażeń!");
            enemy.takeDamage(player.getAttackPower());

            // Sprawdzamy, czy potwór zginął od tego ciosu
            if (!enemy.isAlive()) {
                System.out.println("🏆 " + enemy.getName() + " pada martwy! Wygrywasz starcie!");
                break; // Przerywamy pętlę walki
            }

            // 2. Tura Potwora
            System.out.println("⬅️ " + enemy.getName() + " oddaje cios za " + enemy.getAttackPower() + " obrażeń!");
            player.takeDamage(enemy.getAttackPower());

            // Sprawdzamy, czy gracz zginął
            if (!player.isAlive()) {
                System.out.println("💀 Zginąłeś... Ciemność spowija świat.");
                break; // Przerywamy pętlę walki
            }

            // Wizualny odstęp po każdej pełnej rundzie
            System.out.println("   [Stan: " + player.getName() + " " + player.getHealth() + "HP | " + enemy.getName() + " " + enemy.getHealth() + "HP]\n");
        }
    }
}