package edu.itstep;

public class Main {
    public static void main(String[] args) {
//        MyArrayList<User> listUser = new MyArrayList();
//        //listUser.add(new User("Anton","Lashch","0662609970"));
//        listUser.add(new User("Ivan", "Derkach", "0663331633"));
//        listUser.add(new User("Anton", "Lashch", "0662609970"));
//        //listUser.addToTheBeginning(new User("Ivan","Derkach","0663331633"));
//        //listUser.deleteLast();
//        // listUser.deleteFirst();
//        //listUser.replaceUser(new User("Ivan","Derkach","0663331633"),1);
//        //listUser.insert(new User("Kolia", "Shvaiko", "1234567892"), 0);
//        listUser.print();

//        MyArrayList<Integer> inters = new MyArrayList();
//        inters.add(1);
//        inters.add(13);
//        inters.add(11);
//        inters.print();
        MyLinkedList<User> users = new MyLinkedList<>();
        users.addToTop(new User("Ivan", "Derkach", "0663331633"));
        users.addToTop(new User("Anton", "Lashch", "0662609970"));
        //users.removeLast();
        users.removeFirst();
        users.printList();
    }
}
