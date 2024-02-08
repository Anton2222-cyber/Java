package edu.itstep.ex6;

import org.springframework.stereotype.Component;

@Component
public class Gun {
    public Gun() {
        System.out.println("Gun created");
    }

    public void shoot() {
        System.out.println("piv-pav");
    }

    public void initMethod(){
        System.out.println("initMethod");
    }
    public void destroyMethod(){
        System.out.println("destroyMethod");
    }
}
