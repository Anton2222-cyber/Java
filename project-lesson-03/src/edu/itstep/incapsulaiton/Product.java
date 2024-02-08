package edu.itstep.incapsulaiton;

public class Product {
    private String name;
    private int price;
    private String color;

    //alt + insert

    public Product() {
        this("unknown", 0, "unknown");
        System.out.println("constructor without params");
    }


    public Product(String name, int price, String color) {
        this.name = name;
        this.price = price;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price < 0) {
            this.price = 0;
        } else {
            this.price = price;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
