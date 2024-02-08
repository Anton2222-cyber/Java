package ref;

public class CalculatorUtil {
    private CalculatorUtil() {
    }

    public static double sum(double a, double b) {
        if (a > 0 && b > 0) {
            return a + b;
        }
        return 0;
    }
    public static double sub(double a, double b) {
        return a - b;
    }
}
