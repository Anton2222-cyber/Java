package game;

public abstract class Character {
    private String name;
    private int minAttack;
    private int maxAttack;
    private int health;
    private int maxHealth;

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinAttack() {
        return minAttack;
    }

    public void setMinAttack(int minAttack) {
        this.minAttack = minAttack;
    }

    public int getMaxAttack() {
        return maxAttack;
    }

    public void setMaxAttack(int maxAttack) {
        this.maxAttack = maxAttack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Character(String name, int minAttack, int maxAttack, int health) {
        this.name = name;
        this.minAttack = minAttack;
        this.maxAttack = maxAttack;
        this.maxHealth = this.health = health;

    }

    public void getDamage(int health) {
        this.health -= health;
    }
    public void getHealth(int health) {
        this.health += health;
    }
}
