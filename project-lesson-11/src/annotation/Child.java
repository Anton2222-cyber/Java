package annotation;

//@FirstAnnotation(key1 = 3)
public class Child extends Parent{
    
    @FirstAnnotation(key1 = 1)
    public Child(String name) {
        super(name);
    }

    @FirstAnnotation
    @Override
    @Deprecated(since = "3.4", forRemoval = true)
    public void info() {
        //super.info();
        System.out.println("I'm Child");
    }
}
