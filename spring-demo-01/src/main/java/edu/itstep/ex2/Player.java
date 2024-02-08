package edu.itstep.ex2;

public class Player {
    private Weapon weapon;

    public Player(Weapon weapon) {
        this.weapon = weapon;
    }

    public void shoot(){
        System.out.println("take aim ---> ");
        weapon.shoot();
    }
}
