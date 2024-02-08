package thread3;

public class Main {
    public static void main(String[] args) {
        System.out.println("start " + Thread.currentThread().getName());

        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread, "my thread #1");
        thread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread.stop();

        System.out.println("finish " + Thread.currentThread().getName());
    }
}
