package org.example.stack;
// class punya stack (8-8)
public class Stack {
    private Node first;
    // contructor stack first nya null dulu :<
    public Stack() {
        this.first = null;
    }

    // input data kedalam Node
    public void push(char value) {

        Node newNode = new Node(value);
        // artinya jika data kosong ( fungsi haspop mendeteksi jika data ada / terisi)
        if (!hasPop()) {
            first = newNode;
        } else {
            newNode.setNext(first);
            first = newNode;
        }
        System.out.println("PUSH: Nilai " + value + " masuk kedalam stack.");
    }

    // remove kalo di linked list(ngapus / ngeluarin data)
    public char pop() {
        if (!hasPop()) {
            throw new RuntimeException("Stack tidak memiliki nilai === 0 T_T");
        }
        char valueToReturn = first.getData();
        first = first.getNext();
        System.out.println("POP: Nilai " + valueToReturn + " sudah dihapus dari stack.");
        return valueToReturn;
    }

    // pendeteksi nilai pada stack terisi/kosong *_*
    public boolean hasPop() {
        return first != null;
    }

    // swap dengan parameter urutan index dari data (8-8)
    public void swap_index(int p1, int p2) {

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
        for (int i = 1; i < pos1 && node1 != null; i++) { // lebih relevan untuk konsep LIFO karena hanya
            //dengan batas yang ditentukan
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

        System.out.println("SWAP: Menukar nilai '" + node1.getData() + "' (posisi " + pos1 + ") dengan '" + node2.getData() + "' (posisi " + pos2 + ").");

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
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}