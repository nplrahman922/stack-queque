package org.example.queue;

public class Node {
    private char data;
    private Node prev;
    private Node next;

    public Node(char data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    public void setData(char data) {
        this.data = data; }

    public char getData() {
        return data; }

    public void setPrev(Node prev) {
        this.prev = prev; }

    public Node getPrev() {
        return prev; }

    public void setNext(Node next) {
        this.next = next; }

    public Node getNext() {
        return next; }
}