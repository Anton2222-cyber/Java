package thread7;

public class Main {
    public static void main(String[] args) {
        System.out.println("main start");

        Thread thread1 = new Thread(new MyThread(), "повар 1");
        thread1.start();
        Thread thread2 = new Thread(new MyThread(), "повар 2");
        thread2.start();

        try {
            thread1.join();
            thread2.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("main work!!!");

        System.out.println("finish start");
    }
}
