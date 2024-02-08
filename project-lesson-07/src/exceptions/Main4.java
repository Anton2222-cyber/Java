package exceptions;

public class Main4 {
    public static void main(String[] args) {
        String[] arr = {"one", "two", "three"};

        try {
            System.out.println("before");
            System.out.println(arr[5]);//ctrl + alt + t
            System.out.println("after");
        } catch (Exception e) {
            System.out.println("ERROR");
        } finally {
            System.out.println("finally");
        }
    }
}
