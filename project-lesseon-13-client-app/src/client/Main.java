package client;

public class Main {
    public static void main(String[] args) {
        Client client = new Client("localhost", 44444);
        client.start();
    }
}
