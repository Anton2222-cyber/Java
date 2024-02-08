package dz;

public class Main {
    public static void main(String[] args) {
        int arr[] = new int[10];
        Thread threadFillRandom = new Thread(new ThreadFillRandom(arr));
        threadFillRandom.start();

        try {
            threadFillRandom.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        ThreadMin threadMinData = new ThreadMin(arr);
        ThreadSum threadSumData = new ThreadSum(arr);
        Thread threadMin = new Thread(threadMinData);
        Thread threadSum = new Thread(threadSumData);

        threadMin.start();
        threadSum.start();
        try {
            threadMin.join();
            threadSum.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Сума елементів: " + threadSumData.getSum());
        System.out.println("Мінімальний елемент: " + threadMinData.getMin());
    }
}
