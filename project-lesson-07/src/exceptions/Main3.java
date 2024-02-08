package exceptions;

public class Main3 {
    public static void main(String[] args) {
        String[] arr = {"one", "two", "three"};


        try {
            System.out.println("before");
            System.out.println(arr[5]);//ctrl + alt + t
            System.out.println("after");
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }
}
