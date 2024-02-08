package dz;

import javax.swing.*;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ServerListener implements Runnable {
    private Socket socket;
    private Scanner scanner;
    private static final int MAX_MESSAGES_TO_DISPLAY = 10;
    private JTextArea chatArea;
    private DefaultListModel<String> participantsListModel;
    private JList<String> participantsList;
    Object lock = new Object();
    public ServerListener(Socket socket, JTextArea chatArea, DefaultListModel<String> participantsListModel,JList<String> participantsList) {
        this.participantsList = participantsList;
        this.chatArea = chatArea;
        this.socket = socket;
        this.participantsListModel = participantsListModel;
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
            if(messageFromServer.equals("#clear")){
                participantsListModel.clear();
               // participantsList.revalidate();
            }
            synchronized (lock) {

                if(messageFromServer.startsWith("#Зайшов користувач")){
                    String[] partsAll = messageFromServer.split("|");
                   // List<String> users=new ArrayList<>();
                    for (String part:partsAll) {

                        String[] parts =part.split("користувач\\s+");
                        if (parts.length > 1) {
                            String extractedName = parts[1];

                            participantsListModel.addElement(extractedName);
                            System.out.println(extractedName);
                            //participantsList.revalidate();
                            // Server.sendMessageToAll("#Зайшов користувач " + extractedName + "\n");
                            // System.out.println("Витягнуте ім'я: " + extractedName);

                        }
                    }

//                    String[] parts = partsAll.split("користувач\\s+");
//                    System.out.println(Arrays.toString(parts));
//                   // System.out.println(parts.toString());
//                    // Перевірка частин після розділення
//                    if (parts.length > 1) {
//                        String extractedName = parts[1];
//
//                        participantsListModel.addElement(extractedName);
//                        //participantsList.revalidate();
//                        // Server.sendMessageToAll("#Зайшов користувач " + extractedName + "\n");
//                        // System.out.println("Витягнуте ім'я: " + extractedName);
//
//                    }
                }
            }

            // Опрацювання отриманих повідомлень від сервера
            if (messageFromServer.equals("#lastMessages")) {
                // Якщо сервер відправив запит на останні повідомлення
                displayLastMessages(scanner);
            } else if (messageFromServer.startsWith("USER_JOINED:")) {
                // Якщо приєднався новий користувач
                String username = messageFromServer.substring("USER_JOINED:".length());
                SwingUtilities.invokeLater(() -> participantsListModel.addElement(username));
            } else if (messageFromServer.startsWith("USER_LEFT:")) {
                // Якщо користувач вийшов з чату
                String username = messageFromServer.substring("USER_LEFT:".length());
                SwingUtilities.invokeLater(() -> participantsListModel.removeElement(username));
            } else {
                chatArea.append(messageFromServer);
            }
        }
    }

    private void displayLastMessages(Scanner scanner) {
        int count = 0;
        while (count < MAX_MESSAGES_TO_DISPLAY && scanner.hasNextLine()) {
            String message = scanner.nextLine();
            chatArea.append(message);
            count++;
        }
    }
}
