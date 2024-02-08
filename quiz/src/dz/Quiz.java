package dz;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Quiz {

    public void startQuiz() {
        Scanner scannerIn = new Scanner(System.in);
        int points = 0;
        int questions = 0;
        try (Scanner scanner = new Scanner(new FileInputStream("./quiz.txt"))) {


            while (scanner.hasNextLine()) {
                questions++;
                List<String> answers = new ArrayList<>();
                //Collections.shuffle();
                String line = scanner.nextLine();
                String[] parts = line.split(";");
                for (int i = 1; i < parts.length; i++) {
                    answers.add(parts[i]);
                }
                Collections.shuffle(answers);

                System.out.println(parts[0]);
                int i = 1;
                for (String answer : answers) {
                    System.out.println(answer + "->" + i++);
                }
                int index;
                while (true) {
                    try {
                        System.out.print("Вкажіть варіант відповіді -> ");

                        if (scannerIn.hasNextInt()) {
                            index = scannerIn.nextInt();

                            if (index >= 1 && index < parts.length) {
                                break;
                            } else {
                                System.out.println("Ви ввели некоректний варіант відповіді.");
                            }
                        } else {
                            System.out.println("Ви ввели не ціле число.");
                            scannerIn.next(); // Прочитати некоректне значення, щоб очистити буфер вводу
                        }
                    } catch (Exception ex) {
                        System.out.println("Сталася помилка: " + ex.getMessage());
                        scannerIn.next(); // Прочитати некоректне значення, щоб очистити буфер вводу
                    }
                }
                if (parts[parts.length - 1].equals(answers.get(--index))) {
                    System.out.println("Правильна відповідь!");
                    points++;
                }else {
                    System.out.println("Неправильна відповідь!");
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Ви набрали " + points + " з " + questions + " балів");
    }

}
