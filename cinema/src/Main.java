import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void fillSeats(boolean[][] seats) {
        Random random = new Random();
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                seats[i][j] = random.nextBoolean();
            }
        }
    }
    public static void printSeats(boolean[][] seats) {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j]) {
                    System.out.print(1 + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Кількість рядів ->");
        int n = scanner.nextInt();
        System.out.print("Кількість місць ->");
        int m = scanner.nextInt();
        boolean[][] seats = new boolean[n][m];
        fillSeats(seats);
        System.out.print("Кількість місць потрібно->");
        int k = scanner.nextInt();
        printSeats(seats);

        for (int i = 0; i < seats.length; i++) {
            String infoRow = "";
            for (int j = 0; j < seats[i].length; j++) {
                String infoSeats = "";
                int count = 0;
                for (int l = j; l < seats[i].length; l++) {
                    j=l;
                    if (!seats[i][l]) {
                        infoSeats += l + 1 + ",";
                        count++;
                        continue;
                    }
                    break;
                }
                if (!infoSeats.equals("") && infoSeats.length() > 0) {
                    infoSeats = infoSeats.substring(0, infoSeats.length() - 1);
                }
                if (count >= k) {
                    if (!infoRow.equals("")) {
                        infoRow += " або " + infoSeats;
                    } else {
                        infoRow += infoSeats;
                    }

                }
            }
            if (!infoRow.equals("")) {
                System.out.println(i + 1 + "ряд: " + infoRow + " місця");
            } else {
                System.out.println(i + 1 + "ряд: -");
            }

        }
    }

}
