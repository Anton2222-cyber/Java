package exceptions;

public class MyClass {
    public static void staticMethod(int key) throws Exception {
        if (key < 0) {
            throw new Exception("this is no valid value");
        }
    }

}
