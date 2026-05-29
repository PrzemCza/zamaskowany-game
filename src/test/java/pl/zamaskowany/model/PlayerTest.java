package pl.zamaskowany.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    @Test
    void shouldCreateNewPlayerWithCorrectInitialStats() {
        // given - powołujemy gracza do życia
        Player player = new Player("Zamaskowany", 150);

        // when & then - sprawdzamy, czy konstruktor i gettery działają poprawnie
        assertThat(player.getName()).isEqualTo("Zamaskowany");
        assertThat(player.getMaxHealth()).isEqualTo(150);
        assertThat(player.getHealth()).isEqualTo(150); // Na start zdrowie powinno być równe maksymalnemu
        assertThat(player.getLevel()).isEqualTo(1);    // Zawsze zaczynamy od poziomu 1
    }

    @Test
    void shouldDecreaseHealthWhenTakingDamage() {
        // given
        Player player = new Player("Zamaskowany", 100);

        // when - gracz obrywa za 30 punktów
        player.takeDamage(30);

        // then - powinno mu zostać 70
        assertThat(player.getHealth()).isEqualTo(70);
    }

    @Test
    void shouldNotDropHealthBelowZeroWhenTakingLethalDamage() {
        // given
        Player player = new Player("Zamaskowany", 100);

        // when - gracz otrzymuje śmiertelny cios (więcej obrażeń niż ma HP)
        player.takeDamage(999);

        // then - zdrowie zatrzymuje się dokładnie na 0 (nie ma wartości ujemnych)
        assertThat(player.getHealth()).isEqualTo(0);
    }

    @Test
    void shouldIncreaseHealthWhenHealingButNotAboveMax() {
        // given - gracz ma 100 max HP, ale obrywa za 50
        Player player = new Player("Zamaskowany", 100);
        player.takeDamage(50); // Stan: 50/100 HP

        // when - gracz wypija potężną miksturę leczącą za 200 HP
        player.heal(200);

        // then - zdrowie nie może przekroczyć maxHealth (czyli 100)
        assertThat(player.getHealth()).isEqualTo(100);
    }

    @Test
    void shouldReturnTrueWhenPlayerHasHealth() {
        // given
        Player player = new Player("Zamaskowany", 100);

        // when & then - w pełni zdrowy gracz musi żyć
        assertThat(player.isAlive()).isTrue();
    }

    @Test
    void shouldReturnFalseWhenPlayerTakesLethalDamage() {
        // given
        Player player = new Player("Zamaskowany", 100);

        // when - gracz otrzymuje śmiertelne obrażenia
        player.takeDamage(100);

        // then - metoda isAlive powinna zwrócić fałsz
        assertThat(player.isAlive()).isFalse();
    }
}