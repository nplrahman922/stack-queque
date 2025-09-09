// File: src/main/java/org/example/Main.java
package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan = 0;

        while (pilihan != 3) {
            System.out.println("\n======================================");
            System.out.println("   PROGRAM UTAMA - STACK & QUEUE");
            System.out.println("   Program ini hanya berlaku dengan");
            System.out.println("   karakter 1 variabel");
            System.out.println("======================================");
            System.out.println("Pilih program yang ingin dijalankan:");
            System.out.println("1. Simulasi Stack (Tumpukan)");
            System.out.println("2. Simulasi Queue (Antrean)");
            System.out.println("3. Keluar");
            System.out.print("Masukkan pilihan Anda: ");

            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.println("\n--- Memulai Simulasi Stack ---\n");
                    org.example.stack.Main.main(null);
                    System.out.println("\n--- Simulasi Stack Selesai ---");
                    break;
                case 2:
                    System.out.println("\n--- Memulai Simulasi Queue ---\n");
                    org.example.queue.Main.main(null);
                    System.out.println("\n--- Simulasi Queue Selesai ---");
                    break;
                case 3:
                    System.out.println("Terima kasih telah menggunakan program ini!");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
        scanner.close();
    }
}