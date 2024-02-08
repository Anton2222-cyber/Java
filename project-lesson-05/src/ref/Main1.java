package ref;

public class Main1 {
    public static void main(String[] args) {
        print(String::toUpperCase);
        print(String::toLowerCase);
        print();

//        System.out.println("Hello World".toUpperCase());
    }
    public static void print(Printer printer){
        String data = "Hello World";
        System.out.println(printer.execute(data));
    }
    public static void print(){
        String data = "Hello World";
        System.out.println(data);
    }
}
