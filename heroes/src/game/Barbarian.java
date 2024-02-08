package game;

import java.util.Random;

public class Barbarian extends Character implements Pusher {

    public Barbarian() {
        super("Варвар", 30, 60, 200);
    }

    @Override
    public void attack(Character oponent) {
        oponent.getDamage(new Random().nextInt(getMaxAttack()- getMinAttack()+1)+getMinAttack());
        //int randomNumber = random.nextInt(max - min + 1) + min;
    }

}
