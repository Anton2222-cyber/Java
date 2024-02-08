import org.w3c.dom.ls.LSOutput;

public class Main5 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4, 3, 2};
        //itar
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
        //iter
        for (int value : arr) {
            System.out.println(value);
        }

    }
}
