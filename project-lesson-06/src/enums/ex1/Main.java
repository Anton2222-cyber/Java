package enums.ex1;

public class Main {
    public static void main(String[] args) {
//        Phone phone1 = new Phone(1000, "x105", Colors.RED);
//        Phone phone2 = new Phone(2000, "x305", Colors.RED);
//        Phone phone3 = new Phone(3000, "x505", "Red");
        // System.out.println(phone1.getColor().equals(phone2.getColor()));
//        System.out.println(phone1.getColor().toLowerCase().equals(phone2.getColor().toLowerCase()));

        String color = "white";//значение пришло извне
        //установить цвет unknown, если такого цвета нет среди доступных вариантов

        String colorPhone = hasColor(color) ? color : "unknown";
        Phone phone = new Phone(5000, "x500", colorPhone);
        System.out.println(phone);

    }

    public static boolean hasColor(String color) {
        switch (color) {
            case Colors.RED:
            case Colors.GREEN:
            case Colors.BLUE:
            case Colors.BLACK:
            case Colors.WHITE:
                return true;
        }
        return false;
    }
}
