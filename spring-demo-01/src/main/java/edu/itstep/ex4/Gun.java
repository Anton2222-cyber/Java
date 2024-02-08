package edu.itstep.ex4;

public class Gun implements Weapon {
    public Gun() {
        System.out.println("Gun created");
    }

    @Override
    public void shoot() {
        System.out.println("piv-pav");
    }
}
