package exceptions;

public class Main5 {
    public static void main(String[] args) {
        System.out.println(test(333));
    }

    private static int test(int key) {// return: 13
        if (key < 0) {
            return -1;
        }
//        System.exit(0);
        if (key > 0) {
            try {
                return 777;
//                System.out.println("hello");
            }finally {
                if (true) {
                    return 13;
                }
            }
        }

        return 666;
    }
}
