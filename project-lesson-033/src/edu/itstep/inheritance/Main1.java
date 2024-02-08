package edu.itstep.inheritance;

public class Main1 {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
//        Shape shape = new Shape();
        Rectangle rectangle1 = new Rectangle(Color.RED, "yellow", 2, 6);
        Rectangle rectangle2 = new Rectangle(Color.RED, "orange", 2, 4);
        Circle circle = new Circle("black", "green", 5);

        shapes[0] = rectangle1;
        shapes[1] = rectangle2;
        shapes[2] = circle;

        double sum = 0;
        for (Shape shape : shapes) {
            sum += shape.calcArea();
        }
        System.out.println(sum);


    }

}
