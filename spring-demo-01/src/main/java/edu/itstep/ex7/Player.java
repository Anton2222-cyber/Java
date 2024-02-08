package edu.itstep.ex7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Player {
    private Weapon weapon;

    public Player() {
        System.out.println("Player created");
    }

    public void shoot(){
        System.out.println("take aim ---> ");
        weapon.shoot();
    }

    @Autowired
    public void setWeapon(Weapon weapon) {
        System.out.println("setWeapon()");
        this.weapon = weapon;
    }
}
