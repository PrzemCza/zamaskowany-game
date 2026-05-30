package pl.zamaskowany.model;

public interface Fighter {
    String getName();
    int getHealth();
    int getAttackPower();
    void takeDamage(int damage);
    boolean isAlive();
}
