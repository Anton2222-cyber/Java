import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;
        //System.out.println(randomNumber + " <->");
        int count = 0;
        int attempts = 10;
        int number;
        System.out.println("Вгадайте число!");
        while (count < attempts) {
            System.out.print("Залишилось " + (attempts - count) + " спроб ->");
            number = scanner.nextInt();
            count++;
            if (randomNumber == number) {
                System.out.println("Ви вгадали!");
                break;
            }
        }
        if (attempts == count) {
            System.out.println("Закінчились всі спроби!");
        }

    }
}