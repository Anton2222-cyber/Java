package functional;

import java.util.Random;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
//        Predicate<Integer> predicate = v -> v > 0;
//        System.out.println(predicate.test(-7));

//        Consumer<String> consumer = System.out::println;
//        consumer.accept("Hello World");

//        Function<Phone, Integer> function = v -> v.getPrice();
//        System.out.println(function.apply(new Phone(1000, "x100", Color.RED)));

        Supplier<Integer> supplier = () -> new Random().nextInt(100);
        System.out.println(supplier.get());

    }
}
