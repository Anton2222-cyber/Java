package edu.itstep.ex3;

public class MachineGun implements Weapon {
    public MachineGun() {
        System.out.println("MachineGun created");
    }

    @Override
    public void shoot() {
        System.out.println("tra-ta-ta");
    }
}
