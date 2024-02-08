package local;

public class Outer {
    private String outerField = "outerField";

    public Outer() {

    }

    public void outerMethod() {
        String localField = "localField";

        class Local {
            public String publicField = "public";
            private String privateField = "private";
            private void methodLocale(){
                System.out.println(outerField);
                System.out.println(localField);
                outerField = "new value";//+ //Чому цю змінну можна змінити?
//                localField = "new value";//- //Чому цю змінну не можна змінити?
            }
        }
        Local local = new Local();
        local.methodLocale();

//        System.out.println(local.publicField);
//        System.out.println(local.privateField);
    }
}
