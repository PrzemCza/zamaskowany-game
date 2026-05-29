package pl.zamaskowany;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class MainTest {

    @Test
    void shouldVerifyThatTestEnvironmentWorks() {
        // given
        String gameName = "Zamaskowany Game";

        // when & then
        assertThat(gameName)
                .isNotBlank()
                .startsWith("Zamaskowany")
                .isEqualTo("Zamaskowany Game");
    }

    @Test
    void shouldDemonstrateFailedTest() {
        // given - początkowy stan
        int playerHealth = 100;
        int damageTaken = 20;

        // when - akcja (gracz otrzymuje obrażenia)
        int currentHealth = playerHealth - damageTaken;

        // then - weryfikacja
        // UWAGA: Celowo popełniamy błąd logiczny.
        // Twierdzimy, że po otrzymaniu 20 obrażeń, gracz nadal ma 100 HP.
        assertThat(currentHealth)
                .isEqualTo(80);
    }
}