package enums.ex2;

public class Phone {
    private int price;
    private String model;
    private Color color;

    public Phone(int price, String model, Color color) {
        this.price = price;
        this.model = model;
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "price=" + price +
                ", model='" + model + '\'' +
                ", color=" + color +
                '}';
    }
}
