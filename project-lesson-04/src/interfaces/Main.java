package interfaces;

public class Main {
    public static void main(String[] args) {
//        Cook cook = new Cook();
//        Soldier soldier = new Soldier();
//        Cook cook;
//        Soldier soldier;

//        Man.test2();
//        Man man = new Man();
//        man.test2();

//        Cook.test1();
//        Cook.test2();

//        Man man = new Man("Ragnar");
//        man.go();

        Man man1 = new Man("Ivan", "левая");
        Man man2 = new Man("Petr", "правая");
        Woman woman = new Woman();
        commander(man1, man2);
//        commander(woman);
    }

    public static void commander(Soldier... soldiers) {
        System.out.println("Усім вогонь!");
        for (Soldier soldier : soldiers) {
            soldier.shoot();
        }
    }
}
