package org.example;


public class Stack {

    private Node first;


    public Stack() {
        this.first = null;
    }

    public void push(char value) {

        Node newNode = new Node(value);

        if (!hasPop()) {
            first = newNode;
        } else {
            newNode.setNext(first);
            first = newNode;
        }
        System.out.println("PUSH: Nilai " + value + " masuk kedalam stack.");
    }

    public char pop() {
        if (!hasPop()) {
            throw new RuntimeException("Stack lagi kosong nih");
        }
        char valueToReturn = first.getValue();
        first = first.getNext();
        System.out.println("POP: Nilai " + valueToReturn + " sudah dihapus dari stack.");
        return valueToReturn;
    }

    public boolean hasPop() {
        return first != null;
    }

    public void swap() {
        if (first == null || first.getNext() == null) {
            throw new RuntimeException("Stack harus memiliki minimal 2 elemen untuk bisa ditukar.");
        }

        Node top = first;
        Node second = first.getNext();

        top.setNext(second.getNext());
        second.setNext(top);

        this.first = second;
    }

    public int swap_limited_edition(char newValue) {

        if (first == null) {
            throw new RuntimeException("Stack kosong, tidak ada elemen untuk diganti.");
        }

        char oldValue = first.getValue();

        Node newNode = new Node(newValue);

        newNode.setNext(first.getNext());

        this.first = newNode;

        return oldValue;
    }

    public void display() {
        if (!hasPop()) {
            System.out.println("zzzz -- sistem tidak mendeteksi nilai --- xxx");
        }
        System.out.print("Isi Stack (dari atas ke bawah): ");
        Node current = first;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}