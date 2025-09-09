package org.example.queue;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue antrean = new Queue();
        int pilihan = 0;

        while (pilihan != 6) {
            System.out.println("\n--- Menu Simulasi Antrean (Queue) ---");
            System.out.println("1. Enqueue (Tambah Data)");
            System.out.println("2. Dequeue (Hapus Data)");
            System.out.println("3. Swap berdasarkan Posisi/Index");
            System.out.println("4. Tampilkan Antrean");
            System.out.println("5. Keluar");
            System.out.println("6. Kembali");
            System.out.print("Masukkan pilihan Anda: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    while (true) {
                    System.out.print("Masukkan KARAKTER untuk di-enqueue: ");
                    char dataMasuk = scanner.next().charAt(0);
                    // validasi tidak boleh ada angka
                    if (dataMasuk >= '0' && dataMasuk <= '9') {
                        System.out.println("ERROR: Data tidak boleh berupa angka! Silakan coba lagi.");
                    } else {
                        antrean.enqueue(dataMasuk);
                        break;
                    }
                }
                break;
                case 2:
                    try {
                        antrean.dequeue();
                    } catch (RuntimeException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Masukkan posisi pertama yang akan ditukar: ");
                    int pos1 = scanner.nextInt();
                    System.out.print("Masukkan posisi kedua yang akan ditukar: ");
                    int pos2 = scanner.nextInt();
                    antrean.swap_index(pos1, pos2);
                    break;
                case 4:
                    antrean.display();
                    break;
                case 5:
                    System.out.println("Terima kasih! Program selesai.");
                    System.exit(0);
                case 6:
                    System.out.println("kembali ke menu.");
                    org.example.Main.main(null);
                    break;

                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        }
        scanner.close();
    }
}