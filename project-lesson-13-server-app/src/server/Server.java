package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Server {
    private static final int PORT = 44444;
    private static final int MAX_MESSAGES_TO_KEEP = 10;
    private static final String MESSAGE_FILE = "messages.txt";

    private static List<ClientListener> clientListeners = Collections.synchronizedList(new ArrayList<>());
    private static LinkedList<String> messages = new LinkedList<>();
    List<String> users =new ArrayList<>();
    public void start() {
        loadMessagesFromFile(); // Завантаження повідомлень з файлу при старті сервера

        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                ClientListener clientListener = new ClientListener(socket,users);
                clientListeners.add(clientListener);
                sendLastMessages(clientListener); // Надсилаємо останні повідомлення новому клієнту
                new Thread(clientListener).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadMessagesFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(MESSAGE_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                messages.addLast(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     private static void saveMessageToFile(String message) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(MESSAGE_FILE, true))) {
            writer.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendLastMessages(ClientListener clientListener) {
        int startIndex = Math.max(messages.size() - MAX_MESSAGES_TO_KEEP, 0);
        for (int i = startIndex; i < messages.size(); i++) {
            clientListener.sendMessage(messages.get(i));
        }
    }

    public static void sendMessageToAll(String message) {
        clientListeners.forEach(e -> e.sendMessage(message));
        saveMessageToFile(message); // Зберігання повідомлення у файлі при відправці всім клієнтам
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }
}
