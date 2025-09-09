package org.example.stack;


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

    public char swap_limited_edition(char newValue) {

        if (first == null) {
            throw new RuntimeException("Stack kosong, tidak ada elemen untuk diganti.");
        }

        char oldValue = first.getValue();

        Node newNode = new Node(newValue);

        newNode.setNext(first.getNext());

        this.first = newNode;

        return oldValue;
    }
    // hal ini tetap menyalahi aturan karena stack memiliki konsep akses terbatas T_T (LIFO)
    public void swap_limited2(int p1, int p2) {

        int pos1 = Math.min(p1, p2);
        int pos2 = Math.max(p1, p2);

        if (pos1 <= 0) {
            System.out.println("ERROR: Posisi harus bilangan positif.");
            return;
        }

        if (pos1 == pos2) {
            System.out.println("INFO: Posisi sama, tidak ada yang ditukar.");
            return;
        }

        Node prev1 = null;
        Node node1 = first;
        for (int i = 1; i < pos1 && node1 != null; i++) {
            prev1 = node1;
            node1 = node1.getNext();
        }

        Node prev2 = null;
        Node node2 = first;
        for (int i = 1; i < pos2 && node2 != null; i++) {
            prev2 = node2;
            node2 = node2.getNext();
        }

        if (node1 == null || node2 == null) {
            System.out.println("ERROR: Posisi di luar jangkauan stack.");
            return;
        }

        System.out.println("SWAP: Menukar nilai '" + node1.getValue() + "' (posisi " + pos1 + ") dengan '" + node2.getValue() + "' (posisi " + pos2 + ").");

        if (prev1 != null) {
            prev1.setNext(node2);
        } else {
            this.first = node2;
        }

        if (prev2 != null) {
            prev2.setNext(node1);
        }

        Node temp = node1.getNext();
        node1.setNext(node2.getNext());
        node2.setNext(temp);
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