package dz;

public class ThreadMin implements Runnable {
    private int arr[];
    private int min;

    public int getMin() {
        return min;
    }

    public ThreadMin(int[] arr) {
        this.arr = arr;
        this.min = arr[0];
    }

    @Override
    public void run() {
//        synchronized (this) {
            if (arr.length == 0) {
                throw new IllegalArgumentException("Масив порожній");
            }
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                }
            }
//        }
    }
}
