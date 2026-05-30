package pl.zamaskowany.model;

// Słowo "extends" oznacza: "Dziedziczę wszystkie cechy po GameCharacter"
public class Enemy extends GameCharacter {

    public Enemy(String name, int health, int attackPower) {
        //słowo super przekazuje dane w górę, do konstruktora klasy rodzica
        super(name, health, attackPower);

    }
    // Koniec! Metody takeDamage(), isAlive() i gettery
    // są już automatycznie zaszyte w tej klasie dzięki dziedziczeniu.

}