package edu.itstep.inheritance;

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(String borderColor, String backgroundColor, double width, double height) {
        //System.out.println("Hello World");
        super(borderColor, backgroundColor);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                super.toString();
    }

    @Override
    public double calcArea() {
        return width * height;
    }
}
