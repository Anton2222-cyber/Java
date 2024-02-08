package dz;

public class ThreadSum implements Runnable {
    private int arr[];
    private int sum;

    public int getSum() {
        return sum;
    }

    public ThreadSum(int[] arr) {
        this.arr = arr;
        this.sum = 0;
    }

    @Override
    public void run() {
//        synchronized (this) {
            for (int num : arr) {
                sum += num;
            }
        //}
    }
}
