package annotation;

public @interface SecondAnnotation {
    enum Color{
        RED, GREEN, BLUE
    }
    Color color();
}
