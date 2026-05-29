package pl.zamaskowany.model;

public class Player {
    // Pola klasy - cechy naszego gracza
    private final String name;
    private int health;
    private int maxHealth;
    private int level;

    // Konstruktor - specjalna metoda służąca do powoływania gracza do życia
    public Player(String name, int maxHealth) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth; // Na starcie gracz ma pełne zdrowie
        this.level = 1;          // Każdy zaczyna od 1 poziomu
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getLevel() {
        return level;
    }

    // Metody (Zachowania)
    public void takeDamage(int damage) {
        if (damage > 0) {
            // Math.max wybiera większą z dwóch liczb.
            // Dzięki temu zdrowie nigdy nie spadnie poniżej 0.
            this.health = Math.max(0, this.health - damage);
        }
    }

    public void heal(int amount) {
        if (amount > 0) {
            // Math.min wybiera MNIEJSZĄ z dwóch liczb.
            // Dzięki temu zdrowie nigdy nie przekroczy maxHealth.
            this.health = Math.min(this.maxHealth, this.health + amount);
        }
    }

    public boolean isAlive() {
        return this.health > 0;
    }

}