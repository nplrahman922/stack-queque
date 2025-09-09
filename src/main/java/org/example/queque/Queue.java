package org.example.queque;


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

    public void enqueue(int data) {
        Node newNode = new Node(data);
        System.out.println("Enqueue: " + data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;

        } else  {

            head.next = newNode;

            newNode.prev = head;

            head = newNode;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue kosong!");
        }

        int value = tail.data;
        System.out.println("Dequeue: " + value);

        tail = tail.next;

        if (tail != null) {
            tail.prev = null;
        } else {

            head = null;
        }
        return value;
    }


    public void swap(int data1, int data2) {

        if (data1 == data2) {
            System.out.println("INFO: Nilai sama, tidak ada penukaran.");
            return;
        }

        Node node1 = null, node2 = null;
        Node current = head;
        while (current != null) {
            if (current.data == data1) {
                node1 = current;
            }
            if (current.data == data2) {
                node2 = current;
            }
            current = current.next;
        }

        // 2. Validasi: Pastikan kedua node ditemukan
        if (node1 == null || node2 == null) {
            System.out.println("ERROR: Satu atau kedua data tidak ditemukan dalam list.");
            return;
        }

        System.out.println("SWAP: Menukar posisi " + data1 + " dan " + data2 + ".");

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

        Node temp;

        temp = node1.next;
        node1.next = node2.next;
        node2.next = temp;

        if (node1.next != null) {
            node1.next.prev = node1;
        }
        if (node2.next != null) {
            node2.next.prev = node2;
        }

        // Tukar pointer prev
        temp = node1.prev;
        node1.prev = node2.prev;
        node2.prev = temp;

        if (node1.prev != null) {
            node1.prev.next = node1;
        }
        if (node2.prev != null) {
            node2.prev.next = node2;
        }
    }

    //opsional buat ngecek aja
    public void display() {
        if (isEmpty()) {
            System.out.println("Isi Queue: (Kosong)");
            return;
        }
        System.out.print("Isi Queue (Depan -> Belakang): ");
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}