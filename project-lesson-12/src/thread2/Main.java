package thread2;

public class Main {
    public static void main(String[] args) {
        System.out.println("start " + Thread.currentThread().getName());

        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread, "my thread #1");
        thread.start();

        System.out.println("finish " + Thread.currentThread().getName());
    }
}
