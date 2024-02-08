package org.example.ex4;

import org.springframework.stereotype.Component;

@Component
public class TicketDb {
    private int price;
    private String name;
    public void create(){
        System.out.println("create Ticket()");
    }
    public int getPrice(){
        System.out.println("getPrice()");
        return 100;
    }
    public void checkPrice(){
        System.out.println("checkPrice()");
    }

    public void setPrice(int price) {
        System.out.println("setPrice()");
        this.price = price;
    }


    public void setName(String name) {
        System.out.println("setName()");
        this.name = name;
    }
}
