package edu.itstep.ex3;

public class Player {
    private Weapon weapon;

    public Player() {
        System.out.println("Player created");
    }

    public void shoot(){
        System.out.println("take aim ---> ");
        weapon.shoot();
    }

    public void setWeapon(Weapon weapon) {
        System.out.println("setWeapon()");
        this.weapon = weapon;
    }
}
