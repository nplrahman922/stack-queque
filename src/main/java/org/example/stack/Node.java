package org.example.stack;
    // membuat class T_T
public class Node {
    private char data;
    private Node next;
    // constructor // (9_9)
    public Node(char data) {
        this.data = data;
        this.next = null;
    }

    // buat setter dan getter (ref menggunakan linked list searah -> mengarah ke depan
    public void setNext(Node next) {

        this.next = next;
    }

    public Node getNext() {

        return this.next;
    }

    public char getData() {

        return this.data;
    }

}