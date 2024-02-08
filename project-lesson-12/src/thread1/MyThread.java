package thread1;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("start new Thread");
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("finish new Thread");
    }
}
