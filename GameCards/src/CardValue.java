public enum CardValue {
    CARD_2(2),
    CARD_3(3),
    CARD_4(4),
    CARD_5(5),
    CARD_6(6),
    CARD_7(7),
    CARD_8(8),
    CARD_9(9),
    CARD_10(10),
    CARD_J(10),
    CARD_Q(10),
    CARD_K(10),
    CARD_A(11);

    private int value;

    CardValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
