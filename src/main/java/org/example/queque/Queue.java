// File: Queue.java
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

    // DIPERBAIKI: Logika enqueue (menambah di belakang/tail) agar sesuai FIFO
    public void enqueue(int data) {
        Node newNode = new Node(data);
        System.out.println("Enqueue: " + data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else  {
            // Sambungkan ekor yang lama ke node baru
            tail.setNext(newNode);
            // Sambungkan node baru kembali ke ekor yang lama
            newNode.setPrev(tail);
            // Pindahkan penunjuk tail ke node yang baru
            tail = newNode;
        }
    }

    // DIPERBAIKI: Logika dequeue (menghapus dari depan/head) agar sesuai FIFO
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue kosong!");
        }

        // Ambil data dari head, bukan tail
        int value = head.getData();
        System.out.println("Dequeue: " + value);

        // Pindahkan head ke node berikutnya
        head = head.getNext();

        if (head != null) {
            // Putuskan hubungan head baru dari node sebelumnya
            head.setPrev(null);
        } else {
            // Jika queue menjadi kosong, tail juga harus null
            tail = null;
        }
        return value;
    }

    public void swap(int data1, int data2) {
        if (data1 == data2) {
            return; // Tidak ada yang perlu dilakukan
        }

        // 1. Cari kedua node
        Node node1 = null, node2 = null;
        Node current = head;
        while (current != null) {
            if (current.getData() == data1) node1 = current;
            if (current.getData() == data2) node2 = current;
            current = current.getNext();
        }

        // 2. Validasi (ini sudah benar)
        if (node1 == null || node2 == null) {
            System.out.println("ERROR: Data " + (node1 == null ? data1 : data2) + " tidak ditemukan.");
            return;
        }

        // 3. Simpan node-node di sekitar node1 dan node2
        Node prev1 = node1.getPrev();
        Node next1 = node1.getNext();
        Node prev2 = node2.getPrev();
        Node next2 = node2.getNext();

        // 4. Logika penukaran yang diperbaiki

        // Kasus khusus: jika node bersebelahan
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
        } else {
            // Kasus umum: node tidak bersebelahan
            if (prev1 != null) prev1.setNext(node2);
            node2.setPrev(prev1);
            node2.setNext(next1);
            if (next1 != null) next1.setPrev(node2);

            if (prev2 != null) prev2.setNext(node1);
            node1.setPrev(prev2);
            node1.setNext(next2);
            if (next2 != null) next2.setPrev(node1);
        }

        // 5. Perbarui head dan tail jika perlu
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
        System.out.println("SWAP: Berhasil menukar posisi " + data1 + " dan " + data2 + ".");
    }

    // DIPERBAIKI: Logika display agar menampilkan dari depan (head)
    public void display() {
        if (isEmpty()) {
            System.out.println("Isi Queue: (Kosong)");
            return;
        }
        System.out.print("Isi Queue (Depan -> Belakang): ");
        // Mulai dari head untuk urutan yang benar
        Node current = head;
        while (current != null) {
            System.out.print(current.getData() + " ");
            // Menggunakan getter
            current = current.getNext();
        }
        System.out.println();
    }
}