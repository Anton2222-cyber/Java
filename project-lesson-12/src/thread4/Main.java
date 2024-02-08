package thread4;

public class Main {
    public static void main(String[] args) {
        System.out.println("start " + Thread.currentThread().getName());

        MyThread myThread = new MyThread();
        myThread.start();

        try {
            Thread.sleep(2000);//виконується робота
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        myThread.interrupt();

        System.out.println("main work");
        System.out.println("main work");
        System.out.println("main work");
        System.out.println("main work");
        System.out.println("main work");
        System.out.println("main work");
        System.out.println("main work");
        System.out.println("main work");
        System.out.println("main work");
        System.out.println("main work");
        System.out.println("main work");
        System.out.println("main work");

        System.out.println("finish " + Thread.currentThread().getName());

    }
}
