package interfaces;

public interface Soldier {
    //    public abstract void shoot();
    void shoot();

    default void go(){
        System.out.println("Я умею ходить");
    }

}
