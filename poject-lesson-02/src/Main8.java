import java.util.Arrays;

public class Main8 {
    public static void main(String[] args) {
        //Примитивные vs ссылочные типи,
//        int original = 1;
//        int copy = original;
//        copy = 2;
//        System.out.println(original);

        int[] original = {1, 1, 1};
        int[] copy = original;
        copy[0] = 2;
        copy[1] = 2;
        copy[2] = 2;
        System.out.println(Arrays.toString(original));

    }
}
