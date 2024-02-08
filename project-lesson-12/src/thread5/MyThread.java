package thread5;

public class MyThread extends Thread {//interrupted = true

    @Override
    public void run() {
        System.out.println("start " + Thread.currentThread().getName());

        int count = 0;
        while (!interrupted()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
                System.out.println("ERROR!");
//                break;
                interrupt();
            }
            //важлива робота
            System.out.println(count++);
        }
        System.out.println("finish " + Thread.currentThread().getName());

    }
}
