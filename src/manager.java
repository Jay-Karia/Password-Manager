import java.util.Objects;
import java.util.Scanner;
import java.io.*;
public class manager {
    public static void main(String[] args) {
        println("Welcome to Java Password Manager Developed -- By Jay (v-1.0)");
        println("\nWhat do you want to Do?\n1) Enter a New Password\n2) Retrieve Your Password");
        String sel;
        Scanner selection = new Scanner(System.in);
        sel = selection.nextLine();
        if (sel.equals("1")) {
            println("\nSelected: 1) Enter a new Password");
            println("\nYour Password");
            Scanner pass = new Scanner(System.in);
            String password = pass.nextLine();
            boolean valid;
            do {
                valid = true;
                println("Confirm your Password");
                Scanner newPass = new Scanner(System.in);
                String newPassword = newPass.nextLine();

                if (Objects.equals(password, newPassword)) {
                    println("Password is Set!");
                } else {
                    println("Your password doesn't match! Try again");
                    valid = false;
                }
            } while (valid);
        }
    }

    public static void println(String str) {
        System.out.println(str);
    }
}