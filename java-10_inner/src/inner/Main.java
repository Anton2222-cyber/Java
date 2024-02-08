package inner;

public class Main {
    public static void main(String[] args) {
//        Outer outer = new Outer();
//        Inner inner = new Inner();

        Outer outer = new Outer();
        Outer.Inner inner1 = outer.new Inner();
        Outer.Inner inner2 = outer.new Inner();

//        Outer.Inner inner = new Outer().new Inner();
    }
}
