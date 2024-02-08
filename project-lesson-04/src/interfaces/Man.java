package interfaces;

public class Man implements Cook, Soldier{
    private String name;
    private String hand;

    public Man(String name, String hand) {
        this.name = name;
        this.hand = hand;
    }

    @Override
    public void cook() {

    }

    @Override
    public void shoot() {
        System.out.println("Стреляю рукой " + hand);
    }

    @Override
    public void go() {
        System.out.println(this.name + ": ");
        Soldier.super.go();

    }
}
