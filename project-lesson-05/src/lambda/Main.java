package lambda;

public class Main {
    public static void main(String[] args) {
//        Calculator calculator = new Calculator() {
//            @Override
//            public double execute(double a, double b) {
//                return a * b;
//            }
//        };
//        System.out.println(calculator.execute(2, 5));

//        Calculator calculator = (a, b) -> a + b;
//        System.out.println(calculator);
//        System.out.println(calculator.execute(2, 5));

//        calc(new Calculator() {
//            @Override
//            public double execute(double a, double b) {
//                return a + b;
//            }
//        });
        calc((a, b) -> a + b);
        calc((a, b) -> a * b);

    }

    public static void calc(Calculator calculator) {
        double a = 2;
        double b = 7;
        System.out.println(calculator.execute(a, b));

    }
}
