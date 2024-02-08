package copy.ex6;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        User user = new User("Ivan", 18, new Address("Dnipro", "Dovzhenko"));

        Gson gson = new Gson();

        String jsonUser = gson.toJson(user);
        System.out.println(jsonUser);

        User copy = gson.fromJson(jsonUser, User.class);
        copy.setName("Petr");
        copy.getAddress().setCity("Abramova");

        System.out.println(user);

        long end = System.currentTimeMillis();
        System.out.println(end - start);//130 - 136
    }
}
