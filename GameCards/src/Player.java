public class Player extends Graver {
    private int money;

    public Player(int money) {
        this.money = money;
    }

    public void loseBet(int bet) {
        money -= bet;
    }
    public void winBet(int bet) {
        money += bet;
    }

    public int getMoney() {
        return money;
    }
}
