package client2;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ServerListener implements Runnable{
    private Socket socket;
    private Scanner scanner;

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
        while (scanner.hasNextLine()){
            String message = scanner.nextLine();
            System.out.println(message);
        }

    }
}
