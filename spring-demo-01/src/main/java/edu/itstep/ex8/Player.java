package edu.itstep.ex8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Player {
    private Weapon weapon;

    @Autowired
    public Player(Weapon weapon) {
        System.out.println("Player created");
        this.weapon = weapon;
    }

//    public Player() {
//        System.out.println("Player created empty");
//    }

    public void shoot(){
        System.out.println("take aim ---> ");
        weapon.shoot();
    }


}
