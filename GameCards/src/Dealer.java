public class Dealer extends Graver {
    private Deck deck;

    public Dealer(Deck deck) {
        this.deck = deck;
        this.deck.shuffleDeck();
    }

    public Card getCard() {
        return deck.drawLastCard();
    }

    void addCard() {
        cards.add(getCard());
    }

    public void printFirst() {
        int i = 1;
        for (Card card : cards) {
            if (i == 1) {
                System.out.println(card.getCardValue() + " " + card.getCardSuit());
            } else {
                System.out.println("* ");
            }
            i++;
        }
        //System.out.println();
    }
}
