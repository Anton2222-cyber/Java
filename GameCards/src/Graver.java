import java.util.ArrayList;
import java.util.List;

public class Graver {
    protected List<Card> cards;
    protected int sumPoints;

    public int getSumPoints() {
        return sumPoints;
    }

    public void calculatePoints() {
        sumPoints = 0;


        for (Card card : cards) {
            sumPoints += card.getPoint();
        }


        int numAces = countAces();

        while (numAces > 0 && sumPoints > 21) {
            sumPoints -= 10;
            numAces--;
        }
    }
    private int countAces() {
        int count = 0;
        for (Card card : cards) {
            if (card.getCardValue() == CardValue.CARD_A) {
                count++;
            }
        }
        return count;
    }

    public Graver() {
        cards = new ArrayList<>();
        sumPoints = 0;
    }

    public void clear() {
        cards.clear();
        sumPoints = 0;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void printCards() {
        for (Card card : cards) {
            System.out.println(card.getCardValue() + " " + card.getCardSuit());
        }
        //System.out.println();
    }
}
