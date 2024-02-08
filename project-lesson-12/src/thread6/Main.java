package thread6;

public class Main {
    public static void main(String[] args) {
//        Thread thread1 = new Thread(new MyThread(), "thread # 1 ");
//        Thread thread2 = new Thread(new MyThread(), "thread # 2 ");
//        thread1.setPriority(1);
//        thread2.setPriority(10);
//        thread1.start();
//        thread2.start();
//        System.out.println("finish main!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        Thread thread1 = new Thread(new MyThread(), "thread # 1 ");
        Thread thread2 = new Thread(new MyThread(), "thread # 2 ");
        thread1.setDaemon(true);
        thread2.setDaemon(true);
        thread1.start();
        thread2.start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("finish main!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}
