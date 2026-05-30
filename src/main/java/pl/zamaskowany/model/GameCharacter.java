package pl.zamaskowany.model;

// Słowo "implements Fighter" oznacza, że nasza klasa podpisuje kontrakt
public abstract class GameCharacter implements Fighter {

    private final String name;
    protected int health; // 'protected' pozwala klasom-dzieciom (Player/Enemy) na dostęp do tej zmiennej
    private final int attackPower;

    public GameCharacter(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    @Override // Ta adnotacja informuje kompilator: "Realizuję metodę z interfejsu"
    public String getName() {
        return name;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getAttackPower() {
        return attackPower;
    }

    @Override
    public void takeDamage(int damage) {
        if (damage > 0) {
            this.health = Math.max(0, this.health - damage);
        }
    }

    @Override
    public boolean isAlive() {
        return this.health > 0;
    }
}