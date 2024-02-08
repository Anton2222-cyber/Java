package edu.itstep;

public class MyArrayList<T> {
    private int size = 0;
    private T[] mainArr = (T[])new Object[size];

    public void add(T value) {
        T[] tempArr = (T[])new Object[size + 1];
        for (int i = 0; i < size; i++) {
            tempArr[i] = mainArr[i];
        }
        tempArr[size] = value;
        size++;
        mainArr = tempArr;
    }

    public void addToTheBeginning(T value) {

        T[] tempArr = (T[])new Object[size + 1];
        tempArr[0] = value;
        for (int i = 0,j=1; i < size; i++,j++) {
            tempArr[j] = mainArr[i];
        }
        size++;
        mainArr = tempArr;

    }
    public void replaceUser(T value,int index) {
        if(index>=0&&index<size){
            mainArr[index]=value;
        }else{
            System.out.println("Не інує такого індекса!");
        }

    }
    public void insert(T value,int index) {
        if(index>=0&&index<size) {
            T[] tempArr = (T[])new Object[size + 1];

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
            T[] tempArr = (T[])new Object[--size];
            for (int i = 0; i < size; i++) {
                tempArr[i] = mainArr[i];
            }
            mainArr = tempArr;
        }
    }

    public void deleteFirst() {
        if (size > 0) {
            T[] tempArr = (T[])new Object[size - 1];
            for (int i = 1, j = 0; i < size; i++, j++) {
                tempArr[j] = mainArr[i];
            }
            size--;
            mainArr = tempArr;
        }
    }

    public void print() {
        for (T user : mainArr) {
            System.out.println(user);
        }
    }
}
