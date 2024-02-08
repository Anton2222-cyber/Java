package client2;

//import client2.ServerListener;
import java.io.FileWriter;
import java.text.SimpleDateFormat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class Client {
    private final String IP;
    private String name;
    private final int PORT;
    private static final String FILENAME = "messages.txt";
    private static final int MAX_MESSAGES_TO_KEEP = 10;

    public Client(String IP, int PORT) {
        this.IP = IP;
        this.PORT = PORT;
    }

    private String getCurrentTime() {
        // Встановлюємо формат дати та часу
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // Отримуємо поточну дату та час
        Date currentDate = new Date();

        // Повертаємо поточний час у визначеному форматі
        return dateFormat.format(currentDate);
    }

    private void clearLogFile() {
        try (PrintWriter writer = new PrintWriter(FILENAME)) {
            writer.print(""); // Очищення вмісту файлу
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void logMessage(String message) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME, true))) {
            writer.println(message); // Запис повідомлення у файл
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            clearLogFile(); // Очистити файл при старті клієнта
            Socket socket = new Socket(IP, PORT);
            Thread thread = new Thread(new ServerListener(socket));
            thread.setDaemon(true);
            thread.start();
            Scanner scannerConsole = new Scanner(System.in);
            System.out.print("Введіть ім'я->");
            name = scannerConsole.nextLine();

            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            printWriter.println("Зайшов користувач " + name);
            printWriter.flush();
            while (true) {
                String message = scannerConsole.nextLine();

                if (message.equals("#exit")) {
                    printWriter.println("Вийшов користувач " + name);
                    printWriter.flush();
                    break;
                }
                String logMessage = name + " <" + getCurrentTime() + "> " + " -> " + message;
                printWriter.println(logMessage);
                printWriter.flush();
                logMessage(logMessage); // Запис повідомлення у файл
            }
            //socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
