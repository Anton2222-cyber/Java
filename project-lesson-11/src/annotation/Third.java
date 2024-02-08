package annotation;


public @interface Third {
    String[] value();
    int key() default 111;

    FirstAnnotation first() default @FirstAnnotation(key1 = 123);
}
