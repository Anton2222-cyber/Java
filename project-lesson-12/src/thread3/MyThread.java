package thread3;

public class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.println("start " + Thread.currentThread().getName());
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            //отримати дані
            //перевірити їх
            //зберегти, якщо підходять, зафіксувати цей приход
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("finish " + Thread.currentThread().getName());
    }
}
