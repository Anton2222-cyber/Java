package io_stream;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        //InputStream
        //OutputStream
        try {
            FileInputStream fileInputStream = new FileInputStream("./test.txt");
//            System.out.println((char)fileInputStream.read());

            int i = -1;
            while ((i = fileInputStream.read()) != -1) {
//                System.out.println(i + " = " + (char)i + " ");
                System.out.print((char)i);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
