package exceptions;

import anonym_vs_lambda.Printer;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main1 {
    public static void main(String[] args) {
        //checked
        System.out.println("start");

//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            System.out.println("ERROR!!!");
//        }

        try {
            PrintWriter printWriter = new PrintWriter("A://home.txt");
        } catch (FileNotFoundException e) {
            System.out.println("file not found!!!!");
        }

        System.out.println("finish");
    }
}
