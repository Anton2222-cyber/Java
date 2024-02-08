package annotation;

public class Main {
    public static void main(String[] args) {
        Child child = new Child("test");
        child.info();
        System.out.println(child.getName());
        System.out.println("finish");
    }
}
