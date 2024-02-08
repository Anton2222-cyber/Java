package thread1;

public class Main {
    public static void main(String[] args) {
        System.out.println("start main");

        MyThread myThread = new MyThread();
        myThread.start();

        System.out.println("finish main");
    }
}
