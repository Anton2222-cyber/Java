package inner;

public class Outer {
    public String outerPublicField = "outerPublicField";
    private String outerPrivateField = "outerPrivateField";
    private String staticPrivateOuter = "staticPrivateOuter";

    public String test = "outer";

    public Outer() {
        System.out.println("Outer");
    }

    public void outerMethod() {
        System.out.println(outerPublicField);
        System.out.println(outerPrivateField);
//        System.out.println(innerPrivateField);
//        System.out.println(innerPublicField);
//        Inner inner = new Inner();
//        System.out.println(inner.innerPublicField);
//        System.out.println(inner.innerPrivateField);
//        System.out.println(staticPrivateInner);
        System.out.println(Inner.staticPrivateInner);
    }

    public class Inner {//получает ссылку на объект внешнего класса Outer.this
        public String innerPublicField = "innerPublicField";
        private String innerPrivateField = "innerPrivateField";
        //        public String test = "inner";
        private static String staticPrivateInner = "staticPrivateOuter";

        public Inner() {
            System.out.println("Inner");
            System.out.println(test);
            System.out.println(Outer.this.test);

        }

        public void innerMethod() {
//            System.out.println(innerPublicField);
//            System.out.println(innerPrivateField);
            System.out.println(outerPublicField);
            System.out.println(outerPrivateField);
            Outer outer = new Outer();
            System.out.println(outer.outerPublicField);
            System.out.println(outer.outerPrivateField);
            System.out.println(staticPrivateOuter);
        }
    }
}
