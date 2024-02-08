package edu.itstep.practice;

public class ArrayListInt {
    private int size = 0;
    private int[] mainArr = new int[size];

    public void add(int value) {
        int[] tempArr = new int[size + 1];
        for (int i = 0; i < size; i++) {
            tempArr[i] = mainArr[i];
        }
        tempArr[size] = value;
        size++;
        mainArr = tempArr;
    }
    public void print(){
        for (int numb : mainArr) {
            System.out.print(numb + " ");
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }
}
