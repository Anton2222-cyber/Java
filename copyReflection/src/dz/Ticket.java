package dz;

public class Ticket {
    private int price;
    private String name;

    public Ticket() {
    }

    public Ticket(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}