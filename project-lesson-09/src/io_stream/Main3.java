package io_stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(new FileInputStream("./test.txt"))) {

//            System.out.println(scanner.nextLine());
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
