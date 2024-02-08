import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;
    private DeckSize deckSize;
    public Deck(DeckSize deckSize) {
        this.deckSize =deckSize;
        init();
    }
    private void init(){
//        cards.clear();
        cards = new ArrayList<>();
        if (deckSize == DeckSize.SIZE36) {
            initializeDeckFor36();
        } else {
            initializeDeckFor52();
        }
    }
    private void initializeDeckFor36() {
        CardValue[] valuesFor36 = {
                CardValue.CARD_6, CardValue.CARD_7, CardValue.CARD_8, CardValue.CARD_9,
                CardValue.CARD_10, CardValue.CARD_J, CardValue.CARD_Q, CardValue.CARD_K,
                CardValue.CARD_A
        };

        for (CardSuit suit : CardSuit.values()) {
            for (CardValue value : valuesFor36) {
                cards.add(new Card(value, suit));
            }
        }
    }
    private void initializeDeckFor52() {
        for (CardSuit suit : CardSuit.values()) {
            for (CardValue value : CardValue.values()) {
                cards.add(new Card(value, suit));
            }
        }
    }
    public void shuffleDeck() {
        Collections.shuffle(cards);
    }
    public Card drawLastCard() {
        if (cards.isEmpty()) {
            init();
            shuffleDeck();
        }

        int lastIndex = cards.size() - 1;
        Card lastCard = cards.get(lastIndex);
        cards.remove(lastIndex);

        return lastCard;
    }
    public boolean addCard(Card card) {
        if (cards.contains(card)) {
            return false; // Карта вже є в колоді, повертаємо false
        } else {
            cards.add(card); // Додаємо карту до колоди
            return true; // Карта успішно додана, повертаємо true
        }
    }
    public List<Card> getCards() {
        return cards;
    }

}
