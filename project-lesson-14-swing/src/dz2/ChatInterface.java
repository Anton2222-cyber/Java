package dz2;

import ex7.MyGuiForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatInterface extends JFrame {
    private final String IP;
    private String name;
    private final int PORT;
    private static final String FILENAME = "messages.txt";
    private static final int MAX_MESSAGES_TO_KEEP = 10;
    private JTextArea chatArea;
    private DefaultListModel<String> participantsListModel;
    private JList<String> participantsList;
    private JTextField messageField;
    private  Socket socket;

    private void requestLastMessages(Socket socket) {
        try {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            //printWriter.println("#lastMessages");
            printWriter.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message;
            while ((message = reader.readLine()) != null) {
                // Отримання повідомлення з сервера та обробка його
                chatArea.append(message + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
//    public void initUI() {
//        new Thread(() -> {
//            start();
//        }).start();
//
//        setVisible(true);
//    }

    private void start() {

        clearLogFile(); // Очистити файл при старті клієнта
//        try {
//            socket = new Socket(IP, PORT);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        Thread thread = new Thread(new ServerListener(socket, chatArea, participantsListModel,participantsList));
        thread.setDaemon(true);
        thread.start();
        requestLastMessages(socket);
//            Scanner scannerConsole = new Scanner(System.in);
//            System.out.print("Введіть ім'я->");
//            name = scannerConsole.nextLine();

        //          PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
//           printWriter.println("Зайшов користувач " + name);
//            printWriter.flush();

//            chatArea.append("Зайшов користувач " + name);
//            participantsListModel.addElement(name);
//            participantsList.revalidate();

        // participantsList = new JList<>(participantsListModel);

//             while (true) {
//                String message = scannerConsole.nextLine();
//
//                if (message.equals("#exit")) {
//                    printWriter.println("Вийшов користувач " + name);
//                    printWriter.flush();
//                    break;
//                }
//                String logMessage = name + " <" + getCurrentTime() + "> " + " -> " + message;
//                printWriter.println(logMessage);
//                printWriter.flush();
//                logMessage(logMessage); // Запис повідомлення у файл
//            }

        //socket.close();

    }

    //    private void askForUserName() {
//        String input = JOptionPane.showInputDialog(this, "Будь ласка, введіть своє ім'я:", "Введення імені", JOptionPane.PLAIN_MESSAGE);
//
//        if (input != null && !input.isEmpty()) {
//            this.name = input;
//        } else {
//            JOptionPane.showMessageDialog(this, "Будь ласка, введіть коректне ім'я!", "Помилка", JOptionPane.ERROR_MESSAGE);
//            askForUserName();
//        }
//    }
    private void askForUserNameAndStart() {
        while (true) {
            String input = JOptionPane.showInputDialog(this, "Будь ласка, введіть своє ім'я:", "Введення імені", JOptionPane.PLAIN_MESSAGE);

            if (input != null && !input.isEmpty()) {
                this.name = input;
                PrintWriter printWriter = null;
                try {
                    printWriter = new PrintWriter(socket.getOutputStream());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                printWriter.println("#Зайшов користувач " + name + "\n");
                printWriter.flush();
                chatArea.append("Зайшов користувач " + name + "\n");

                participantsListModel.addElement(name);
                participantsList.revalidate();


                startInSeparateThread(); // Запуск методу start() після отримання валідного імені
                break; // Вихід з циклу, якщо ім'я введено
            } else {
                JOptionPane.showMessageDialog(this, "Будь ласка, введіть коректне ім'я!", "Помилка", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

//    private void askForUserNameAndStart() {
//        askForUserName();
//        start();
//    }

    public ChatInterface(String IP, int PORT) {
        //askForUserName();
        this.IP = IP;
        this.PORT = PORT;
        try {
            socket = new Socket(IP, PORT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setTitle("Чат");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        // Ліва зона для чату (зеленого кольору)
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane chatScrollPane = new JScrollPane(chatArea);
        chatScrollPane.setBackground(Color.GREEN); // Задання кольору фону
        chatArea.setBackground(Color.black);
        chatArea.setForeground(Color.red);
        add(chatScrollPane, BorderLayout.CENTER);

        // Права зона для учасників чату (синього кольору)
        participantsListModel = new DefaultListModel<>();
        participantsList = new JList<>(participantsListModel);
        //participantsList = new JList<>(new String[]{"Учасник 1", "Учасник 2", "Учасник 3"});
        JScrollPane participantsScrollPane = new JScrollPane(participantsList);
        participantsScrollPane.setPreferredSize(new Dimension(150, 0));
        participantsScrollPane.setBackground(Color.BLUE); // Задання кольору фону
        participantsList.setBackground(Color.black);
        participantsList.setForeground(Color.blue);
        add(participantsScrollPane, BorderLayout.EAST);

        // Нижня зона для відправки повідомлення (жовтого кольору)
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(Color.YELLOW); // Задання кольору фону

        messageField = new JTextField();
        bottomPanel.add(messageField, BorderLayout.CENTER);

        JButton sendButton = new JButton("Надіслати");
        sendButton.addActionListener(e -> sendMessage());
        bottomPanel.add(sendButton, BorderLayout.EAST);

        add(bottomPanel, BorderLayout.SOUTH);

        askForUserNameAndStart();

        // name="Anton";
        //start();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("close");
                participantsListModel.removeElement(name);
                participantsList.revalidate();
                // participantsList = new JList<>(participantsListModel);
            }
        });
        //setVisible(true);
    }
    public void startInSeparateThread() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.submit(() -> {
            start();
        });

        executorService.shutdown(); // Завершує роботу потоку після завершення завдання
    }

    private void sendMessage() {
        String message = messageField.getText();
        // Отримання тексту з поля та відправка повідомлення
        String logMessage = name + " <" + getCurrentTime() + "> " + " -> " + message+"\n";
//                printWriter.println(logMessage);
//                printWriter.flush();
        try {
            //socket = new Socket(IP, PORT);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            printWriter.println(logMessage);
            printWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//           printWriter.println("Зайшов користувач " + name);

        logMessage(logMessage); // Запис повідомлення у файл
        chatArea.append(logMessage);
        messageField.setText(""); // Очищення поля для введення
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ChatInterface chatInterface = new ChatInterface("localhost", 44444);
            chatInterface.setVisible(true);
            //chatInterface.initUI();
        });
    }

}
