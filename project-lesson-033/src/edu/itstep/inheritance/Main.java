package edu.itstep.inheritance;

public class Main {
    public static void main(String[] args) {
//        Rectangle rectangle = new Rectangle(Color.RED, "yellow", 2, 6);
//        System.out.println(rectangle);
////        System.out.println(rectangle.toString());
////        String res1 = rectangle;
//        String res2 = rectangle.toString();
//        Circle circle = new Circle("black", "green", 5);
//        System.out.println(circle);


//        Shape shape = new Circle("black", "white", 3);
//        System.out.println(shape.toString());

        Rectangle rectangle1 = new Rectangle(Color.RED, "yellow", 2, 6);
        Rectangle rectangle2 = new Rectangle(Color.RED, "orange", 2, 4);
        Circle circle = new Circle("black", "green", 5);
//        System.out.println(rectangle1.calcArea());
//        System.out.println(rectangle2.calcArea());
//        System.out.println(circle.calcArea());
        System.out.println(rectangle1);
        System.out.println(rectangle2);
        System.out.println(circle);
    }
}
