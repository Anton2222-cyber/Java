public class Main1 {
    public static void main(String[] args) {
//        int number = 1;
//        String result;
//        if (number >= 0) {
//            result = "positive";
//        } else {
//            result = "negative";
//        }
//        System.out.println(result);

        int number = 1;
        String result = number >= 0 ? "positive" : returnNegative();

    }
    public static String returnNegative(){
        return "negative";
    }
}
