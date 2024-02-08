package edu.itstep.ex4;

import java.util.List;

public class Player {
    private String nickName;
    private int bullet;
    private List<Weapon> weapons;

    public Player() {
        System.out.println("Player created");
    }

    public void shoot() {
        //System.out.println(weapons.size());
        int bulletsToShoot = bullet / 2; // Половина куль
        System.out.println("before shoot: " + bullet);
        System.out.println(nickName + " take aim ---> ");
        for (int i = 0; i < bulletsToShoot; i++) {
            weapons.get(0).shoot(); // Виклик методу shoot для пістолета
            bullet--;
        }

        for (int i = 0; i < bulletsToShoot; i++) {
            weapons.get(1).shoot(); // Виклик методу shoot для автомата
            bullet--;
        }
        System.out.println("after shoot: " + bullet);

    }

    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setBullet(int bullet) {
        this.bullet = bullet;
    }
}
