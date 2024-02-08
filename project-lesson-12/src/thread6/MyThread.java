package thread6;

public class MyThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20_000; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
