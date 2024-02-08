package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientListener implements Runnable {
    private Socket socket;
    private Scanner scanner;
    private PrintWriter printWriter;
    List<String> users;

    public ClientListener(Socket socket,List<String> users) {
        this.socket = socket;
        this.users=users;

        try {
            scanner = new Scanner(socket.getInputStream());
            printWriter = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        while (scanner.hasNextLine()) {
            String messageFromClient = scanner.nextLine();
            System.out.println(messageFromClient);
            if(messageFromClient.startsWith("#Зайшов користувач")){
                String[] parts = messageFromClient.split("користувач\\s+");
                // Перевірка частин після розділення
                if (parts.length > 1) {
                    String extractedName = parts[1];
                    //Server.sendMessageToAll("#Зайшов користувач " + extractedName + "\n");
                   // System.out.println("Витягнуте ім'я: " + extractedName);

                    users.add("#Зайшов користувач " + extractedName + "\n");
                    System.out.println(users.size());
                    Server.sendMessageToAll("#clear");
                    String message ="";
                    for (String user : users) {
//                        Server.sendMessageToAll(user);
//                        System.out.println(user);
                        message+= user+"|";
                    }
                    Server.sendMessageToAll(message);

                }
            }

            Server.sendMessageToAll(messageFromClient);
        }
    }

    public void sendMessage(String message) {
        printWriter.println(message);
        printWriter.flush();
    }
}
