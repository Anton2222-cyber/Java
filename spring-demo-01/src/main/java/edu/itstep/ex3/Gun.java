package edu.itstep.ex3;

public class Gun implements Weapon {
    public Gun() {
        System.out.println("Gun created");
    }

    @Override
    public void shoot() {
        System.out.println("piv-pav");
    }
}
