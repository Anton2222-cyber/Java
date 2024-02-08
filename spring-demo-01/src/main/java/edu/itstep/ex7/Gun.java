package edu.itstep.ex7;

import org.springframework.stereotype.Component;

@Component
public class Gun implements Weapon {
    public Gun() {
        System.out.println("Gun created");
    }

    @Override
    public void shoot() {
        System.out.println("piv-pav");
    }
}
