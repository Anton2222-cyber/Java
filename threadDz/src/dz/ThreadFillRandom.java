package dz;

import java.util.Random;

public class ThreadFillRandom implements Runnable {
    private int arr[];

    public ThreadFillRandom(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100); // Генерувати числа в межах від 0 до 99 (включно)
        }
    }
}
