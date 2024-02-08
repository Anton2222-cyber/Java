package Dictionary;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {
    private Map<String, String> engUk;
    private Map<String, String> ukEng;

    public Dictionary() {
        engUk = new HashMap<>();
        engUk.put("cat", "кіт");
        engUk.put("dog", "собака");
        engUk.put("sun", "сонце");
        engUk.put("flower", "квітка");
        engUk.put("mother", "мама");
        engUk.put("father", "тато");
        engUk.put("laptop", "ноутбук");
        engUk.put("phone", "телефон");

        ukEng = new HashMap<>();
        for (Map.Entry<String, String> pair : engUk.entrySet()) {
            ukEng.put(pair.getValue(), pair.getKey());
        }
    }

    private void addWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть слово англійською->");
        String wordEng = scanner.nextLine();
        System.out.print("Введіть слово українською->");
        String wordUk = scanner.nextLine();
        engUk.put(wordEng, wordUk);
        ukEng.put(wordUk, wordEng);

    }

    private void runDictionary(int i) {

        String word = "";
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Додати слово ->1");
            System.out.println("Переключити словник на англ-укр ->2");
            System.out.println("Переключити словник на укр-англ ->3");
            System.out.println("Вихід ->#exit#");
            System.out.print("Введіть слово ->");
            word = scanner.nextLine();
            if (word.equals("#exit#")) {
                break;
            } else if (word.equals("1")) {
                addWord();
                continue;
            } else if (word.equals("2")) {
                i = 1;
            }else if (word.equals("3")) {
                i = 2;
            }
            if (i == 1) {
                System.out.println(word + " --> " + engUk.get(word));
            } else {
                System.out.println(word + " --> " + ukEng.get(word));
            }


        }
    }


    public void openDictionary() {
        int number = 0;
        Scanner scanner = new Scanner(System.in);
        while (number != 1 && number != 2) {
            System.out.println("Виберіть словник:");
            System.out.println("англо-український ->1");
            System.out.println("українсько-англійський ->2");
            System.out.print("->");
            number = scanner.nextInt();
        }
        runDictionary(number);
    }
}
