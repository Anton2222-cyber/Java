package dz;

public class Main {
    public static void main(String[] args)  {
        User original = new User("Anton", "Lashch", new Ticket(140, "Napoleon"));
        User copy = null;
        copy = ObjectCopier.copyObject(original);
        System.out.println("Original: " + original);
        System.out.println("Copy: " + copy);

    }
}
