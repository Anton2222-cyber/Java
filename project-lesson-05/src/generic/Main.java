package generic;

public class Main {
    public static void main(String[] args) {
//        Passport passport1 = new Passport("101a");
//        Passport passport2 = new Passport("102");
//        int id1 = Integer.parseInt(passport1.getId());
//        int id2 = Integer.parseInt(passport2.getId());
//        System.out.println(id1 + id2);

//        PassportGeneric passport1 = new PassportGeneric("101");
//        PassportGeneric passport2 = new PassportGeneric(202);
//        int id1 = Integer.parseInt((String) passport1.getId());
//        int id2 = (int) passport2.getId();
//        System.out.println(id1 + id2);

        PassportGeneric<Integer> passport1 = new PassportGeneric<>(101);
        PassportGeneric<Integer> passport2 = new PassportGeneric<>(202);//int char
        PassportGeneric<String> passport3 = new PassportGeneric<>("303a");//int char
        int id1 = passport1.getId();
        int id2 = passport2.getId();
        String id3 = passport3.getId();
        System.out.println(id1 + id2);

    }
}
