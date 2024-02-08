package nested;

public class Outer {
    public String outerPublicField = "outerPublicField";
    private String outerPrivateField = "outerPrivateField";
    private static String staticPrivateOuter = "staticPrivateOuter";

    public Outer() {
        System.out.println("Outer");
    }

    public void outerMethod() {
        System.out.println(outerPublicField);
        System.out.println(outerPrivateField);
//        System.out.println(nestedPrivateField);
//        System.out.println(nestedPublicField);
//        System.out.println(staticPrivateNested);
        System.out.println(Nested.staticPrivateNested);

    }

    public static class Nested {//не получает ссылку на внешний класс
        public String nestedPublicField = "nestedPublicField";
        private String nestedPrivateField = "nestedPrivateField";
        private static String staticPrivateNested = "staticPrivateNested";

        public Nested() {
            System.out.println("Nested");

        }

        public void nestedMethod() {
            System.out.println(nestedPublicField);
            System.out.println(nestedPrivateField);
//            System.out.println(outerPrivateField);
//            System.out.println(outerPublicField);
            System.out.println(staticPrivateOuter);
        }
    }
}
