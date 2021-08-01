import java.util.Objects;
import java.util.Scanner;
import java.io.*;
public class manager {
    public static void main(String[] args){
        println("Welcome to Java Password Manager Developed -- By Jay (v-1.0)");
        println("\nWhat do you want to Do?\n1) Enter a New Password\n2) Retrieve Your Password");
        String sel;
        Scanner selection = new Scanner(System.in);
        sel = selection.nextLine();
        if (sel.equals("1")) {
            println("\nSelected: 1) Enter a new Password");

            println("\nEnter your name");
            Scanner name = new Scanner(System.in);
            String n = name.nextLine();

            println("\nEnter the purpose for your Password (ex: Email)");
            Scanner purpose = new Scanner(System.in);
            String p = purpose.nextLine();

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
                    println("\nEnter the Security Key for your Password");
                    Scanner security = new Scanner(System.in);
                    String key = security.nextLine();
                    setPassword(key, n, password, p);
                } else {
                    println("Your password doesn't match! Try again");
                    valid = false;
                }
            } while (!valid);
        }
    }

    public static void println(String str) {
        System.out.println(str);
    }

    public static void setPassword(String securityKey, String name, String password, String purpose) {

        try {
            File file = new File("User Passwords\\" + securityKey + ".txt");
            Writer writer = new FileWriter(file);

            writer.write("Name: " + name);
            writer.write("Password: " + password);
            writer.write("Purpose for storing the password: " + purpose);
            writer.write("Security Key: " +  securityKey);
            if (file.createNewFile()) {
                println("Your Password is Successfully Saved!");
            }

            writer.flush();
            writer.close();
        } catch (IOException ex) {
            println("\nAn Error occurred while storing your Password! Sorry");
        }

    }
}