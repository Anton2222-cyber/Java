import java.util.Scanner;

public class Main12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        System.out.println(a);
        System.out.println(b);
        System.out.println(a == b);//false
        System.out.println(a.equals(b));//true
    }
}
