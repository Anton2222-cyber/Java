public class Main6 {
    public static void main(String[] args) {
        //for vs for each
        int[] arr = {1, 3, 2, 4, 3, 2};
        for (int value : arr) {
            value *= 2;//змінюєму копію
        }
        for (int value : arr) {
            System.out.print(value + " ");
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 2;//змінюємо елемент масиву
        }
        System.out.println();
        for (int value : arr) {
            System.out.print(value + " ");
        }

    }
}
