package org.example.stack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Stack testStack = new Stack();

        Scanner scanner = new Scanner(System.in);
        Stack tumpukan = new Stack();
        int pilihan = 0;

        while (pilihan != 6) {
            System.out.println("\n--- Menu Simulasi Tumpukan (Stack) ---");
            System.out.println("1. Push (Tambah Data)");
            System.out.println("2. Pop (Hapus Data)");
            System.out.println("3. Swap berdasarkan Posisi/Index");
            System.out.println("4. Tampilkan Tumpukan");
            System.out.println("5. Keluar");
            System.out.println("6. Kembali");
            System.out.print("Masukkan pilihan Anda: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    while (true) {
                        System.out.print("Masukkan KARAKTER untuk di-push: ");
                        char dataMasuk = scanner.next().charAt(0);
                        //validasi
                        if (dataMasuk >= '0' && dataMasuk <= '9') {
                            System.out.println("ERROR: Data tidak boleh berupa angka! Silakan coba lagi.");
                        } else {
                            tumpukan.push(dataMasuk);
                            break;
                        }
                    }
                    break;
                case 2:
                    try {
                        tumpukan.pop();
                    } catch (RuntimeException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Masukkan posisi pertama yang akan ditukar: ");
                    int pos1 = scanner.nextInt();
                    System.out.print("Masukkan posisi kedua yang akan ditukar: ");
                    int pos2 = scanner.nextInt();
                    tumpukan.swap_index(pos1, pos2);
                    break;
                case 4:
                    tumpukan.display();
                    break;
                case 5:
                    System.out.println("Terima kasih! Program selesai.");
                    System.exit(0);
                case 6:
                    System.out.println("kembali ke menu");
                    org.example.Main.main(null);
                    break;

                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        }
        scanner.close();
    }
}