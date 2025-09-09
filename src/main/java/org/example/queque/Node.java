package org.example.queque;

public class Node {
    private int data;
    private Node prev;
    private Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    // Getters and Setters
    public void setData(int data) { this.data = data; }
    public int getData() { return data; }
    public void setPrev(Node prev) { this.prev = prev; }
    public Node getPrev() { return prev; }
    public void setNext(Node next) { this.next = next; }
    public Node getNext() { return next; }
}