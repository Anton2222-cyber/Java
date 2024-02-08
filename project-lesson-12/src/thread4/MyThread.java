package thread4;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("start " + Thread.currentThread().getName());

        int count = 0;
        while (!interrupted()) {
            //оримання данних
            //перевірка
            //збереження
            System.out.println(count++);
        }
        System.out.println("finish " + Thread.currentThread().getName());

    }
}
