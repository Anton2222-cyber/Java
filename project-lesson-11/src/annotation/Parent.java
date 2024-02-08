package annotation;

public class Parent {
    private String name;

    public Parent(String name) {
        this.name = name;
    }

    @SecondAnnotation(color = SecondAnnotation.Color.RED)
    public String getName() {//скоро удалится
        return name;
    }


    @SecondAnnotation(color = SecondAnnotation.Color.GREEN)
    public void setName(String name) {
        this.name = name;
    }

    @Third(value = {"one", "two"},first = @FirstAnnotation(key1 = 66666))
    public void info() {
        System.out.println("I'm parent!");
    }
}
