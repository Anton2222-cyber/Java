package enums.ex2;

public enum Color {
    RED("#FF0000","червоний"),
    GREEN("#00FF00","зелений"),
    BLUE("#0000FF","синій"),
    YELLOW("#FFFF00","жовтий"),
    DEFAULT("unknown","невідомий");


    Color(String hex, String ua) {
        this.hex = hex;
        this.ua = ua;
    }

    public final String hex;
    public final String ua;

    static boolean isColor(String colorString) {
        for (Color color : Color.values()) {
            if (color.name().equals(colorString.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

}
