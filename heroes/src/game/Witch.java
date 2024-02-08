package game;

import java.util.Random;

public class Witch extends Character implements Pusher, Doctor {
    private final int healthPower = 50;
    private int poison;
    private int countPoison;

    public Witch() {
        super("Відьма", 20, 50, 150);
        poison = 0;
        countPoison = 0;
    }

    @Override
    public void toHealth(Character partner) {
        if (partner.getHealth() + healthPower < partner.getMaxHealth()) {
            partner.getHealth(healthPower);
        } else {
            partner.setHealth(partner.getMaxHealth());
        }
    }

    @Override
    public void attack(Character oponent) {
        if (countPoison < 3) {
            countPoison++;
        } else {
            poison = 0;
        }
        oponent.getDamage(new Random().nextInt(getMaxAttack() - getMinAttack() + 1) + getMinAttack() + poison);

    }

    public boolean toCurse(Character oponent) {
        if (countPoison == 0) {
            poison = 15;
            countPoison++;
            oponent.getDamage(poison);
            return true;
        }
        return false;
    }
}
