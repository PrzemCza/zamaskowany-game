package pl.zamaskowany.engine;

import org.junit.jupiter.api.Test;
import pl.zamaskowany.model.Enemy;
import pl.zamaskowany.model.Player;

import static org.assertj.core.api.Assertions.assertThat;

class CombatEngineTest {

    @Test
    void shouldPlayerWinWhenIsMuchStronger() {
        // given - Potężny gracz i słaby potwór
        Player hero = new Player("Zamaskowany", 100, 50);
        Enemy weakMonster = new Enemy("Szczur", 20, 5);
        CombatEngine engine = new CombatEngine();

        // when - Rozpoczynamy walkę
        engine.fight(hero, weakMonster);

        // then - Gracz powinien przeżyć, a potwór zginąć
        assertThat(hero.isAlive()).isTrue();
        assertThat(weakMonster.isAlive()).isFalse();

        // Sprawdzamy też, czy szczur zadał chociaż jeden cios przed śmiercią
        // (ponieważ to gracz atakuje pierwszy, szczur zginie w 1 rundzie i nie odda ciosu)
        assertThat(hero.getHealth()).isEqualTo(100);
    }

    @Test
    void shouldMonsterWinWhenPlayerIsTooWeak() {
        // given - Bardzo słaby gracz i potężny Boss
        Player weakHero = new Player("Zamaskowany", 10, 2);
        Enemy boss = new Enemy("Smok", 500, 100);
        CombatEngine engine = new CombatEngine();

        // when - Rozpoczynamy walkę
        engine.fight(weakHero, boss);

        // then - Gracz pada martwy, potwór przeżywa
        assertThat(weakHero.isAlive()).isFalse();
        assertThat(boss.isAlive()).isTrue();
    }
}