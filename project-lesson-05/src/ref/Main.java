package ref;

import lambda.Calculator;

import java.math.MathContext;

public class Main {
    public static void main(String[] args) {
//        calcData(new CalcSum());
//        CalcSum calcSum1 = new CalcSum();
//        CalcSum calcSum2 = new CalcSum();
//        CalcSum calcSum3 = new CalcSum();
//        calcData(new CalcSub());

//        calcData(new Calculator() {
//            @Override
//            public double execute(double a, double b) {
//                return a + b;
//            }
//        });

//        calcData((a, b) -> a + b);
//        calcData((a, b) -> a + b);
//        calcData((a, b) -> a + b);

//        calcData((a, b) -> {
//            if (a > 0 && b > 0) {
//                return a + b;
//            }
//            return 0;
//        });
//        calcData((a, b) -> {
//            if (a > 0 && b > 0) {
//                return a + b;
//            }
//            return 0;
//        });
//        calcData((a, b) -> {
//            if (a > 0 && b > 0) {
//                return a + b;
//            }
//            return 0;
//        });

        calcData(CalculatorUtil::sum);
        calcData(CalculatorUtil::sum);
        calcData(CalculatorUtil::sum);
        calcData(CalculatorUtil::sub);
    }

    public static void calcData(Calculator calculator) {
        int x = 2;
        int y = 4;
        System.out.println(calculator.execute(x, y));

    }
}
