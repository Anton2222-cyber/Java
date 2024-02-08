package io_stream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main5 {
    public static void main(String[] args) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter("./test3.txt", true))) {
            printWriter.println("Hello");
            printWriter.println("World");
            printWriter.println("Привет");
            printWriter.println("Мир");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
