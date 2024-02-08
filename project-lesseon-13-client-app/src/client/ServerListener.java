package client;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ServerListener implements Runnable{
    private Socket socket;
    private Scanner scanner;
    private static final int MAX_MESSAGES_TO_DISPLAY = 10;

    public ServerListener(Socket socket) {
        this.socket = socket;
        try {
            scanner = new Scanner(socket.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        while (scanner.hasNextLine()) {
            String messageFromServer = scanner.nextLine();

            // Опрацювання отриманих повідомлень від сервера
            if (messageFromServer.equals("#lastMessages")) {
                // Якщо сервер відправив запит на останні повідомлення
                displayLastMessages(scanner);
            } else {
                System.out.println(messageFromServer);
            }
        }

    }
    private void displayLastMessages(Scanner scanner) {
        System.out.println("Останні " + MAX_MESSAGES_TO_DISPLAY + " повідомлень:");
        int count = 0;
        while (count < MAX_MESSAGES_TO_DISPLAY && scanner.hasNextLine()) {
            String message = scanner.nextLine();
            System.out.println(message);
            count++;
        }
    }
}
