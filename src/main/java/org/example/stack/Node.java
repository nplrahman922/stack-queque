package org.example.stack;

public class Node {
    // Atribut private untuk menyimpan nilai dan referensi ke node berikutnya
    private char value;
    private Node next;

    // Constructor untuk membuat node baru dengan nilai awal
    public Node(char value) {
        this.value = value;
        this.next = null; // Awalnya, node baru tidak menunjuk ke mana pun
    }

    // Method untuk mengatur node berikutnya
    public void setNext(Node next) {

        this.next = next;
    }

    // Method untuk mendapatkan node berikutnya
    public Node getNext() {

        return this.next;
    }

    // Method untuk mendapatkan nilai dari node
    public char getValue() {

        return this.value;
    }
}