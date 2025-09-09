package org.example.queque;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Simulasi Antrean (Queue) dengan Prinsip FIFO ---");
        Queue antreanLoket = new Queue();

        antreanLoket.enqueue(10);
        antreanLoket.enqueue(20);
        antreanLoket.enqueue(30);
        antreanLoket.enqueue(40);
        antreanLoket.enqueue(10);

        System.out.println("--- Sebelum Swap ---");
        antreanLoket.display();
        antreanLoket.swap(20, 30);

        System.out.println("\n--- Setelah Swap ---");
        antreanLoket.display();

        System.out.println("\nMulai melayani antrean:");
        antreanLoket.dequeue();
        antreanLoket.display();

        antreanLoket.dequeue();
        antreanLoket.display();
    }
}