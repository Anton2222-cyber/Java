package exceptions;

public class Main6 {
    public static void main(String[] args) {
        System.out.println("start");
        method1();
        System.out.println("end");
    }
    private static void method1() {
        method2();
        System.out.println("method1");
    }
    private static void method2() {
        method3();
        System.out.println("method2");
    }
    private static void method3() {
        System.out.println("finish");
        throw new RuntimeException("THE END!");
    }
}
