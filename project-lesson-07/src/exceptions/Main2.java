package exceptions;

public class Main2 {
    public static void main(String[] args) {

        System.out.println("start");
//        throw new RuntimeException("test!");
//        System.out.println("finish");

        try {
            MyClass.staticMethod(-333);
        } catch (Exception e) {
            System.out.println("boooom!");
        }
        System.out.println("continue...");
        System.out.println("finish");
    }
}
