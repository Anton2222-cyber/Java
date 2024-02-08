package enums.ex2;

public class Main {
    public static void main(String[] args) {
//        Phone phone = new Phone(1000, "x100", Color.RED);
//        System.out.println(phone.getColor());
        //String color = phone.getColor();
        //String color = phone.getColor().toString();
//        String color = phone.getColor().name();
//        System.out.println(color);

//        Color color = Color.GREEN;
//        System.out.println(color.ordinal());
//        System.out.println(color.hex);
//        color.hex = "something;";

        String res = "black";//значение пришло извне
        //установить цвет unknown, если такого цвета нет среди доступных вариантов

        Color colorPhone = Color.DEFAULT;

//        for (Color color : Color.values()) {
//            if (color.toString().equals(res.toUpperCase())) {
//                colorPhone = color;
//                break;
//            }
//        }
        Color color = Color.isColor(res) ? Color.valueOf(res.toUpperCase()) : Color.DEFAULT;
        Phone phone = new Phone(5000, "x500", color);
        System.out.println(phone);
        System.out.println(phone.getColor().hex);

    }
}
