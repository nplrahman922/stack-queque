// File: Queue.java
package org.example.queue;

public class Queue {
    private Node head;
    private Node tail;

    public Queue() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    // Logika enqueue (menambah di belakang/tail) agar sesuai FIFO
    public void enqueue(char data) {
        Node newNode = new Node(data);
        System.out.println("Enqueue: " + data);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else  {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
    }

    public char dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue kosong!");
        }

        char value = head.getData();
        System.out.println("Dequeue: " + value);

        head = head.getNext();

        if (head != null) {
            head.setPrev(null);
        } else {
            tail = null;
        }
        return value;
    }

    public void swap_index(int p1, int p2) {
        if (p1 == p2) return;

        Node node1 = head;
        for (int i = 1; i < p1 && node1 != null; i++) {
            node1 = node1.getNext();
        }

        Node node2 = head;
        for (int i = 1; i < p2 && node2 != null; i++) {
            node2 = node2.getNext();
        }

        if (node1 == null || node2 == null) {
            System.out.println("ERROR: Posisi di luar jangkauan queue.");
            return;
        }

        Node prev1 = node1.getPrev();
        Node next1 = node1.getNext();
        Node prev2 = node2.getPrev();
        Node next2 = node2.getNext();

        if (next1 == node2) { // node1 tepat sebelum node2
            if (prev1 != null) prev1.setNext(node2);
            node2.setPrev(prev1);
            node2.setNext(node1);
            node1.setPrev(node2);
            node1.setNext(next2);
            if (next2 != null) next2.setPrev(node1);
        } else if (next2 == node1) { // node2 tepat sebelum node1
            if (prev2 != null) prev2.setNext(node1);
            node1.setPrev(prev2);
            node1.setNext(node2);
            node2.setPrev(node1);
            node2.setNext(next1);
            if (next1 != null) next1.setPrev(node2);
        } else { // Kasus umum
            if (prev1 != null) prev1.setNext(node2);
            node2.setPrev(prev1);
            node2.setNext(next1);
            if (next1 != null) next1.setPrev(node2);

            if (prev2 != null) prev2.setNext(node1);
            node1.setPrev(prev2);
            node1.setNext(next2);
            if (next2 != null) next2.setPrev(node1);
        }

        if (head == node1) {
            head = node2;
        } else if (head == node2) {
            head = node1;
        }

        if (tail == node1) {
            tail = node2;
        } else if (tail == node2) {
            tail = node1;
        }
        System.out.println("SWAP: Berhasil menukar posisi " + p1 + " dan " + p2 + ".");
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Isi Queue: (Kosong)");
            return;
        }
        System.out.print("Isi Queue (Depan -> Belakang): ");
        Node current = head;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}