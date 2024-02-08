package exceptions;

public class Main {
    public static void main(String[] args) {
        //unchecked
        System.out.println("start");
//        int[] arr = new int[3];
//        System.out.println(arr[3]);

        String s = null;
        System.out.println(s.toUpperCase());
        System.out.println("finish");
    }
}
