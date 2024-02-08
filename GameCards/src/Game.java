import java.io.*;
import java.util.Scanner;

public class Game {
    private Dealer dealer;
    private Player player;

    public Game() {
        player = new Player(2000);
    }

//    public Game(int money) {
//        player = new Player(money);
//    }

    private void saveGame() {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter("./save.txt"))) {
            printWriter.println(player.getMoney());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void downloadGame() {
        try (Scanner scanner = new Scanner(new FileInputStream("./save.txt"))) {
            player = new Player(Integer.parseInt(scanner.nextLine()));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Нова гра ->1 завантажити гру ->2");
        System.out.print("->");
        int number = scanner.nextInt();
        if(number ==2){
            downloadGame();
        }

        System.out.println("Якою колодою гратимете? 36->1 52->2");
        System.out.print("->");
         number = scanner.nextInt();
        if (number == 1) {
            System.out.println("Обрано 36");
            dealer = new Dealer(new Deck(DeckSize.SIZE36));
        } else {
            System.out.println("Обрано 52");
            dealer = new Dealer(new Deck(DeckSize.SIZE52));
        }

        while (true) {
            player.clear();
            dealer.clear();
            System.out.println("Ваш банк: " + player.getMoney() + "$");
            System.out.print("Ставка ->");
            int bet = scanner.nextInt();
            while (true) {
                if (bet > 0 && bet <= player.getMoney()) {
                    break;
                } else {
                    System.out.println("Не коректна ставка!");
                }
                System.out.print("Ставка ->");
                bet = scanner.nextInt();
            }
            dealer.addCard();
            dealer.addCard();
            dealer.calculatePoints();
            System.out.println("Дилер:");
            dealer.printFirst();
            player.addCard(dealer.getCard());
            player.addCard(dealer.getCard());
            player.calculatePoints();
            System.out.println("Ви:    сума очок: " + player.getSumPoints());
            player.printCards();

            while (player.getSumPoints() < 21) {
                System.out.println("Берете ще карту ->1 ні->2");
                System.out.print("->");
                int num = scanner.nextInt();
                if (num == 1) {
                    player.addCard(dealer.getCard());
                    player.calculatePoints();
                    System.out.println("Ви:    сума очок: " + player.getSumPoints());
                    player.printCards();
                } else if (num == 2) {
                    break;
                }
            }
            if (player.getSumPoints() > 21) {
                System.out.println("Ви програли!");
                player.loseBet(bet);
                continue;
            }
            if (player.getMoney() <= 0) {
                System.out.println("Ви все програли!");
                break;
            } else {
                while (dealer.getSumPoints() < 17) {
                    dealer.addCard();
                    dealer.calculatePoints();
                }
                System.out.println("Дилер:");
                dealer.printFirst();
                if (dealer.getSumPoints() > 21) {
                    System.out.println("Ви виграли!");
                    player.winBet(bet);
                } else if (dealer.getSumPoints() > player.getSumPoints()) {
                    System.out.println("Ви програли!");
                    player.loseBet(bet);
                } else if (dealer.getSumPoints() < player.getSumPoints()) {
                    System.out.println("Ви виграли!");
                    player.winBet(bet);
                } else if (dealer.getSumPoints() == player.getSumPoints()) {
                    System.out.println("Нічия!");
                }
                System.out.println("Розкриваємо карти:");
                System.out.println("Дилер:   сума очок: " + dealer.getSumPoints());
                dealer.printCards();
                if (player.getMoney() <= 0) {
                    System.out.println("Ви все програли!");
                    break;
                }
                System.out.println("Покидаєте стіл? так->1 ні->2 зберегти і вийти->3");
                System.out.print("->");
                int num = scanner.nextInt();
                if (num == 1) {
                    break;
                } else if (num == 3) {
                    saveGame();
                    break;
                }
            }

        }
    }
}
