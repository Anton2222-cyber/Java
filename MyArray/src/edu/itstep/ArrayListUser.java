package edu.itstep;

public class ArrayListUser {
    private int size = 0;
    private User[] mainArr = new User[size];

    public void add(User value) {
        User[] tempArr = new User[size + 1];
        for (int i = 0; i < size; i++) {
            tempArr[i] = mainArr[i];
        }
        tempArr[size] = value;
        size++;
        mainArr = tempArr;
    }

    public void addToTheBeginning(User value) {

        User[] tempArr = new User[size + 1];
        tempArr[0] = value;
        for (int i = 0,j=1; i < size; i++,j++) {
            tempArr[j] = mainArr[i];
        }
        size++;
        mainArr = tempArr;

    }
    public void replaceUser(User value,int index) {
        if(index>=0&&index<size){
           mainArr[index]=value;
        }else{
            System.out.println("Не інує такого індекса!");
        }

    }
    public void insert(User value,int index) {
        if(index>=0&&index<size) {
            User[] tempArr = new User[size + 1];

            for (int i = 0; i < index; i++) {
                tempArr[i] = mainArr[i];
            }
            tempArr[index] = value;
            for (int i = index + 1, j = index; j < size; i++, j++) {
                tempArr[i] = mainArr[j];
            }
            size++;
            mainArr = tempArr;
        }else{
            System.out.println("Не інує такого індекса!");
        }
    }

    public void deleteLast() {
        if (size > 0) {
            User[] tempArr = new User[--size];
            for (int i = 0; i < size; i++) {
                tempArr[i] = mainArr[i];
            }
            mainArr = tempArr;
        }
    }

    public void deleteFirst() {
        if (size > 0) {
            User[] tempArr = new User[size - 1];
            for (int i = 1, j = 0; i < size; i++, j++) {
                tempArr[j] = mainArr[i];
            }
            size--;
            mainArr = tempArr;
        }
    }

    public void print() {
        for (User user : mainArr) {
            System.out.println(user);
        }
    }
}
