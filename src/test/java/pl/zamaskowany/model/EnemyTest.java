package pl.zamaskowany.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class EnemyTest {

    @Test
    void shouldCreateEnemyWithCorrectStats() {
        // given
        Enemy enemy = new Enemy("Goblin", 30, 5);

        // when & then
        assertThat(enemy.getName()).isEqualTo("Goblin");
        assertThat(enemy.getHealth()).isEqualTo(30);
        assertThat(enemy.getAttackPower()).isEqualTo(5);
    }

    @Test
    void shouldDecreaseHealthWhenTakingDamage() {
        // given
        Enemy enemy = new Enemy("Ork", 50, 10);

        // when
        enemy.takeDamage(20);

        // then
        assertThat(enemy.getHealth()).isEqualTo(30);
    }

    @Test
    void shouldDieWhenTakingLethalDamage() {
        // given
        Enemy enemy = new Enemy("Slime", 10, 2);

        // when
        enemy.takeDamage(15);

        // then
        assertThat(enemy.getHealth()).isEqualTo(0);
        assertThat(enemy.isAlive()).isFalse();
    }
}