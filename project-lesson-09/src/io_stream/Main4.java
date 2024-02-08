package io_stream;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Writer;

public class Main4 {
    public static void main(String[] args) {

//        try (PrintWriter printWriter = new PrintWriter("./test2.txt")) {
////            printWriter.println("Привет!");
////            printWriter.println("Мир!");
////            printWriter.write("Привет!\n");
////            printWriter.write("Мир!");
//
//
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }

        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter("./test2.txt");
            printWriter.println("Привет!");
            printWriter.println("Мир!");

            printWriter.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        finally {
            printWriter.close();
        }
    }
}
