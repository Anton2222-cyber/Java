package interfaces;

public interface Cook {
    //    public static final int key = 1;
    int KEY = 1;

    private static void test1() {
        System.out.println("test static method1");
    }

    public static void test2() {
        System.out.println("test static method2");
    }

    void cook();

    default void go(){
        System.out.println("Я умею ходить по другому");
    }


}
