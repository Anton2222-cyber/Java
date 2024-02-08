package edu.itstep;

public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    private int size;
    public int getSize() {
        return size;
    }
    private static class Node<T> {
        private T data;
        private Node<T> prev;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void addToTop(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void removeLast() {
        if (head != null) {
            if (tail == head) {
                tail = head = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
            size--;
        }

    }
    public void removeFirst() {
        if (head != null) {
            if (tail == head) {
                tail = head = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            size--;
        }

    }

    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println();
    }


}
