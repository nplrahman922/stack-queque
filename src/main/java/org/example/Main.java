package org.example;
import org.example.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("===== Program Demonstrasi Stack berdasarkan UML =====");
        Stack myStack = new Stack();

        // Menampilkan status awal
        System.out.println("Apakah stack bisa di-pop? " + myStack.hasPop()); // Harusnya false
        myStack.display();
        System.out.println();

        // Melakukan operasi PUSH
        myStack.push('a');
        myStack.push('b');
        myStack.push('c');
        System.out.println();

        // Menampilkan status setelah PUSH
        myStack.display();
        System.out.println("Apakah stack bisa di-pop? " + myStack.hasPop()); // Harusnya true
        System.out.println();

        // Melakukan operasi POP
        // Karena LIFO, 30 akan keluar lebih dulu
        char poppedValue1 = myStack.pop();

        // Karena LIFO, 20 akan keluar berikutnya
        System.out.println();
        myStack.display();
        System.out.println();

        System.out.println("Apakah stack bisa di-pop? " + myStack.hasPop()); // Harusnya false

        myStack.swap();
        myStack.display();

        myStack.swap_limited_edition('d');
        System.out.println("Apakah stack bisa di-pop? " + myStack.hasPop());
        myStack.display();

        // Baris di bawah ini akan menyebabkan error karena stack sudah kosong
        try {
            myStack.pop();
        } catch (java.util.EmptyStackException e) {
            System.out.println("\nPercobaan POP GAGAL: Stack sudah kosong!");
        }
    }
}