package org.example.queque;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Simulasi Antrean (Queue) dengan Prinsip FIFO ---");
        Queue antreanLoket = new Queue();

        // Orang-orang mulai mengantre
        antreanLoket.enqueue(10);
        antreanLoket.enqueue(20);
        antreanLoket.enqueue(30);
        antreanLoket.enqueue(40);
        antreanLoket.enqueue(10);
        antreanLoket.display();
        antreanLoket.swap(2,4);
        antreanLoket.display();

        System.out.println("\nMulai melayani antrean:");
        antreanLoket.dequeue();
        antreanLoket.display();

        antreanLoket.dequeue();
        antreanLoket.display();
    }
}