package pl.zamaskowany.model;

public class Player extends GameCharacter {
    // Pola klasy - cechy naszego gracza, które są unikalne poza dziedziczeniem.
    private int maxHealth;
    private int level;

    // Konstruktor - specjalna metoda służąca do powoływania gracza do życia
    public Player(String name, int maxHealth, int attackPower) {
        // Przekazujemy imię, ZDROWIE (które na start równa się maxHealth) i siłę ataku do rodzica
        super(name, maxHealth, attackPower);
        // Inicjalizujemy unikalne cechy gracza
        this.maxHealth = maxHealth;
        this.level = 1;
    }

    //Gettery tylko dla gracza.
    public int getMaxHealth() {
        return maxHealth;
    }

    public int getLevel() {
        return level;
    }

    // Metody (Zachowania), leczenie jest na razie zarezerwowane tylko dla gracza

    public void heal(int amount) {
        if (amount > 0) {
            // Math.min wybiera MNIEJSZĄ z dwóch liczb.
            // Dzięki temu zdrowie nigdy nie przekroczy maxHealth.
            // Dzięki 'protected' w GameCharacter, mamy dostęp do 'this.health'
            this.health = Math.min(this.maxHealth, this.health + amount);
        }
    }

}